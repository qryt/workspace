package com.py.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.bean.Aisle;
import com.py.bean.Equipment;
import com.py.bean.Merchandise;
import com.py.bean.Order;
import com.py.bean.OrderMessage;
import com.py.bean.OrderSelectBy;
import com.py.bean.Payment;
import com.py.dao.AisleMapper;
import com.py.dao.EquipmentMapper;
import com.py.dao.MerchandiseMapper;
import com.py.dao.OrderMapper;
import com.py.dao.OrderMessageMapper;
import com.py.dao.PaymentMapper;
import com.py.socket.HairUtil;
import com.py.util.ExcelUtils;
import com.py.util.OfTime;


@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	MerchandiseMapper merchandiseMapper;
	@Autowired
	PaymentMapper paymentMapper;
	@Autowired
	AisleMapper aisleMapper;
	@Autowired
	EquipmentMapper equipmentMapper;
	@Autowired
	OrderMessageMapper orderMessageMapper;
	
	public int deleteByPrimaryKey(Integer orderId) {
		return orderMapper.deleteByPrimaryKey(orderId);
	}

	public int insert(Order record) {
		return orderMapper.insert(record);
	}

	public int insertSelective(Order record) {
		return orderMapper.insertSelective(record);
	}

	public Order selectByPrimaryKey(Integer orderId) {
		return orderMapper.selectByPrimaryKey(orderId);
	}

	public int updateByPrimaryKeySelective(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Order record) {
		return orderMapper.updateByPrimaryKey(record);
	}

	public List<Order> selectByExample(Order order) {
		return orderMapper.selectByExample(order);
	}

	public Order selectByPrimary(Order order) {
		return orderMapper.selectByPrimary(order);
	}

	public Order getPickupCode(Order order) {
		return orderMapper.getPickupCode(order);
	}

	public List<Order> selectOrderByExample(String orderNumber, String orderPaymentId, String orderStatus, String createStartTime, String createEndTime, String updateStartTime, String updateEndTime) {
		List<Order> orders = orderMapper.selectOrderByExample(orderNumber,orderPaymentId,orderStatus,createStartTime,createEndTime,updateStartTime,updateEndTime);
		for (Order order : orders) {
			order.setMerchandise(merchandiseMapper.selectByPrimaryKey(order.getOrderMerchandiseId()));
			order.setPayment(paymentMapper.selectByPrimaryKey(order.getOrderPaymentId()));
		}
		return orders;
	}

	public List<Order> selectOrderByExample(OrderSelectBy orderSelectBy) {
		
		List<Order> orders = orderMapper.selectOrderByExample(orderSelectBy);
		/*for (Order order : orders) {
			order.setMerchandise(merchandiseMapper.selectByPrimaryKey(order.getOrderMerchandiseId()));
			order.setPayment(paymentMapper.selectByPrimaryKey(order.getOrderPaymentId()));
		}
		*/
		
		return orders;
	}

	public void ExportExcel(Integer area, Integer province, Integer city, Integer orderChannel, Integer orderPointName,
			Integer orderStatus, Integer orderEquipmentName, Integer orderAisleNum, Integer orderMerchandiseName,
			HttpServletResponse response) throws Exception {
		
		OrderSelectBy orderSelectBy = new OrderSelectBy();
		orderSelectBy.setPointCity(city);						//城市
		orderSelectBy.setPointDistrict(area);					//区域
		orderSelectBy.setPointProvince(province);				//省份
		orderSelectBy.setChannelId(orderChannel);				//渠道
		orderSelectBy.setPointId(orderPointName);				//点位
		orderSelectBy.setStatus(orderStatus);					//状态
		orderSelectBy.setEquipmentId(orderEquipmentName);		//设备
		orderSelectBy.setAisleId(orderAisleNum);				//货道
		orderSelectBy.setMerchandiseId(orderMerchandiseName);	//商品
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Order> orderList = orderMapper.selectOrderByExample(orderSelectBy);
		
		 String[] headers = {"订单编号","渠道订单编号","商品","数量","支付方式","订单状态","订单创建时间","支付时间" };  
		 String fileName = "订单信息表";  
		 List<Object[]> dataList = new ArrayList<Object[]>();
		 for (int i = 0; i < orderList.size(); i++) {
			 Order order = orderList.get(i);
			 
			 	Merchandise merchandise = order.getMerchandise();
			 	Payment payment = order.getPayment();
			 	
				Object[] objs = new Object[headers.length];
				objs[0] = (order.getOrderNumber()) == null ? "-" : order.getOrderNumber();
				objs[1] = (order.getOrderChannelNumber()) == null ? "-" : order.getOrderChannelNumber();
				if (merchandise == null) {
					objs[2] = "-";
				}else{
					objs[2] = (merchandise.getMerchandiseName()) == null ? "-" : merchandise.getMerchandiseName();
				}
				objs[3] = (order.getOrderMerchandiseAmount()) == null ? "-" : order.getOrderMerchandiseAmount();
				if (payment == null) {
					objs[4] = "-";
				}else{
					objs[4] = (payment.getPaymentName()) == null ? "-" : payment.getPaymentName();
				}
				if (order.getOrderStatus() == null) {
					objs[5] = "";
				}else if(order.getOrderStatus() == 1){
					objs[5] = "未付款";
				}else if(order.getOrderStatus() == 2){
					objs[5] = "待出货";
				}else if(order.getOrderStatus() == 3){
					objs[5] = "待确认收货";
				}else if(order.getOrderStatus() == 4){
					objs[5] = "交易完成";
				}else if(order.getOrderStatus() == 5){
					objs[5] = "取消交易";
				}else if(order.getOrderStatus() == 6){
					objs[5] = "交易关闭";
				}else if(order.getOrderStatus() == 7){
					objs[5] = "货道故障";
				}else if(order.getOrderStatus() == 8){
					objs[5] = "出货超时";
				}
				objs[6] = (order.getOrderCreateTime()) == null ? "-" : order.getOrderCreateTime();
				objs[7] = (order.getOrderPaymentTime()) == null ? "-" : order.getOrderPaymentTime();
				
				dataList.add(objs);
		}
		
      ExcelUtils ex = new ExcelUtils(fileName,headers,dataList);
		
		try{
			OutputStream output = response.getOutputStream();
          response.reset();
          response.setHeader("Content-disposition",
                  "attachment; filename=PersonList.xls");
          response.setContentType("application/msexcel");
          ex.export(output);
          output.close();
		
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	//回调成功处理出货等流程
	public Integer payCallBack(Order order,String buyer_email, String trade_no) {
		order.setOrderChannelNumber(trade_no);
		order.setOrderUserName(buyer_email);
		order.setOrderStatus(2);
		order.setOrderPaymentTime(OfTime.getLongTime());
		
		int i = orderMapper.updateByPrimaryKeySelective(order);
		if(i == 1) {//成功
			order = orderMapper.selectByPrimaryKey(order.getOrderId());
			if(order != null) {
				if(order.getOrderStatus() == 2) {//待出货
					//查到到匹配好的货道
					Aisle aisle = aisleMapper.selectByPrimaryKey(order.getOrderAisleId());
					//再次判断货道状态没问题
					if(aisle != null && aisle.getAisleStatus() == 1) {
						Equipment equipment = equipmentMapper.selectByPrimaryKey(aisle.getAisleEquipmentId());
						if(equipment != null && equipment.getEquipmentStatus() == 1) {
							String str = "BB "+aisle.getAisleNumber()+" "+order.getOrderId()+" CC";
							if(HairUtil.put(str, equipment.getEquipmentSocketKey())) {//发送出货指令
								order.setOrderStatus(3);//状态改为待确认收货
								order.setOrderAisleId(aisle.getAisleId());//订单记录货道信息
								try {
									i = orderMapper.updateByPrimaryKeySelective(order);
									if(i == 0) {//预防万一,修改失败了就再修改一次,再错就不管了
										order = orderMapper.selectByPrimaryKey(order.getOrderId());
										order.setOrderStatus(3);//状态改为待确认收货
										order.setOrderAisleId(aisle.getAisleId());//订单记录货道信息
										
										try {
											orderMapper.updateByPrimaryKeySelective(order);
										} catch (Exception e1) {
											orderMessage("渠道订单编号为:"+order.getOrderChannelNumber()+"因发送出货指令后的数据库操作出错,修改状态失败");
										}
									}
								} catch (Exception e) {//发送出货指令后，修改状态失败
									orderMessage("渠道订单编号为:"+order.getOrderChannelNumber()+"因发送出货指令后的数据库操作出错,修改状态失败");
								}
							}else {
								orderMessage("渠道订单编号为:"+order.getOrderChannelNumber()+"因发送指令不成功,出货不成功");
							}
						}else {//当设备离线时
							order.setOrderStatus(7);//设备锁定未出货
							try {
								orderMapper.updateByPrimaryKeySelective(order);
							} catch (Exception e) {}
							orderMessage("渠道订单编号为:"+order.getOrderChannelNumber()+"因设备锁定未出货");
						}
					}else {//当设备离线时，逻辑待定
						order.setOrderStatus(7);//货道锁定未出货
						try {
							orderMapper.updateByPrimaryKeySelective(order);
						} catch (Exception e) {}
						orderMessage("渠道订单编号为:"+order.getOrderChannelNumber()+"因货道锁定未出货");
					}
				}
			}
		}
		
		return i;
	}
	
	public void orderMessage(String msg){
		OrderMessage message = new OrderMessage();
		message.setContent(msg);
		message.setCreateTime(OfTime.getLongTime());
		try {
			orderMessageMapper.insertSelective(message);
		} catch (Exception e1) {}
	}
	
}
