package com.py.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.py.bean.Equipment;
import com.py.dao.EquipmentMapper;
import com.py.util.SocketSpace;

public class HairUtil {
	//创建一个hashMap，用来保存设备连接socket对象
	public static Map<String, SocketSpace> map = new HashMap<String, SocketSpace>();
	
	public static boolean put(String str,String key){
		SocketSpace socketSpace = map.get(key);
		if(socketSpace != null) {
			PrintStream out = null;
			out = socketSpace.getOut();
			if(out != null) {
				out.println(str);
				System.out.println("向客户端发送--"+str);
				return true;
			}
		}
		return false;
	}
	//去除客户端发送上来的数据的特殊字符
	public static String replaceSpecialStr(String str) {
        str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+","");
        str = str.trim();
        return str;
    }
	
	/*** 
     * @comments 计算两个时间的时间差 
     * @param strTime1 
     * @param strTime2 
     */  
    public static int getTimeDifference(String strTime1,String strTime2) {  
        //格式日期格式，在此我用的是"2018-01-24 19:49:50"这种格式  
        //可以更改为自己使用的格式，例如：yyyy/MM/dd HH:mm:ss 。。。  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        int timeLength = 0;
           try{  
               Date now = df.parse(strTime1);  
               Date date=df.parse(strTime2);  
               long l=now.getTime()-date.getTime();       //获取时间差  
               long day=l/(24*60*60*1000);  
               long hour=(l/(60*60*1000)-day*24);  
               long min=((l/(60*1000))-day*24*60-hour*60);
               long s=(l/1000-day*24*60*60-hour*60*60-min*60);  
               timeLength = (int)s;
           }catch(Exception e){  
               e.printStackTrace();  
           }
		return timeLength;  
    }
	
  //关闭socket,设置设备为离线状态,并且删掉map
  	public static void socketClose(String address,EquipmentMapper equipmentMapper) {
  		SocketSpace socketSpace = map.get(address);
  		if(socketSpace != null) {
  			Equipment equipment = new Equipment();
  			equipment.setEquipmentSocketKey(address);
  			equipment = equipmentMapper.selectByPrimary(equipment);
  			if(equipment != null) {
  				equipment.setEquipmentStatus(0);//离线
  				equipmentMapper.updateByPrimaryKeySelective(equipment);
  			}
  			try {
  				if(socketSpace.getOut() != null) {
  					socketSpace.getOut().close();//关闭输出流
  				}
  				if(socketSpace.getIs() != null) {
  					socketSpace.getIs().close();//关闭输入流
  				}
  				if(socketSpace.getSocket() != null) {
  					socketSpace.getSocket().close();//关闭socket
  				}
  			}catch (IOException e1) {}
  			HairUtil.map.remove(address);//删除map的socket
  		}
  	}
    
  //把16进制的字符串装换成16进制形式的byte数组 
    public static byte[] toByteArray(String string) {
    	String[] s = string.split(" ");
        byte[] by = new byte[s.length];
        for (int i = 0; i < s.length; i++) {
        	by[i] = (byte) Integer.parseInt(s[i],16);
        }
        return by;
    }
  	
}