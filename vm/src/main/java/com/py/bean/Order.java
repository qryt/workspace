package com.py.bean;

public class Order {
    private Integer orderId;

    private String orderNumber;

    private String orderChannelNumber;

    private String orderUserName;

    private Integer orderPointId;

    private Integer orderEquipmentId;

    private Integer orderAisleId;

    private Integer orderChannelMerchandiseId;

    private Integer orderMerchandiseId;

    private Integer orderMerchandiseAmount;

    private Integer orderPaymentId;

    private Double orderPrice;

    private String orderPickupCode;

    private Integer orderStatus;

    private Integer orderReturnNumber;

    private Integer orderReturnSchedule;

    private Integer orderVersions;

    private String orderCreateTime;

    private String orderPaymentTime;

    private String orderUpdateTime;

    private Merchandise merchandise;
    
    private Payment payment;
    
    private Equipment equipment;
    
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderChannelNumber() {
        return orderChannelNumber;
    }

    public void setOrderChannelNumber(String orderChannelNumber) {
        this.orderChannelNumber = orderChannelNumber == null ? null : orderChannelNumber.trim();
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName == null ? null : orderUserName.trim();
    }

    public Integer getOrderPointId() {
        return orderPointId;
    }

    public void setOrderPointId(Integer orderPointId) {
        this.orderPointId = orderPointId;
    }

    public Integer getOrderEquipmentId() {
        return orderEquipmentId;
    }

    public void setOrderEquipmentId(Integer orderEquipmentId) {
        this.orderEquipmentId = orderEquipmentId;
    }

    public Integer getOrderAisleId() {
        return orderAisleId;
    }

    public void setOrderAisleId(Integer orderAisleId) {
        this.orderAisleId = orderAisleId;
    }

    public Integer getOrderChannelMerchandiseId() {
        return orderChannelMerchandiseId;
    }

    public void setOrderChannelMerchandiseId(Integer orderChannelMerchandiseId) {
        this.orderChannelMerchandiseId = orderChannelMerchandiseId;
    }

    public Integer getOrderMerchandiseId() {
        return orderMerchandiseId;
    }

    public void setOrderMerchandiseId(Integer orderMerchandiseId) {
        this.orderMerchandiseId = orderMerchandiseId;
    }

    public Integer getOrderMerchandiseAmount() {
        return orderMerchandiseAmount;
    }

    public void setOrderMerchandiseAmount(Integer orderMerchandiseAmount) {
        this.orderMerchandiseAmount = orderMerchandiseAmount;
    }

    public Integer getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(Integer orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPickupCode() {
        return orderPickupCode;
    }

    public void setOrderPickupCode(String orderPickupCode) {
        this.orderPickupCode = orderPickupCode == null ? null : orderPickupCode.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderReturnNumber() {
        return orderReturnNumber;
    }

    public void setOrderReturnNumber(Integer orderReturnNumber) {
        this.orderReturnNumber = orderReturnNumber;
    }

    public Integer getOrderReturnSchedule() {
        return orderReturnSchedule;
    }

    public void setOrderReturnSchedule(Integer orderReturnSchedule) {
        this.orderReturnSchedule = orderReturnSchedule;
    }

    public Integer getOrderVersions() {
        return orderVersions;
    }

    public void setOrderVersions(Integer orderVersions) {
        this.orderVersions = orderVersions;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime == null ? null : orderCreateTime.trim();
    }

    public String getOrderPaymentTime() {
        return orderPaymentTime;
    }

    public void setOrderPaymentTime(String orderPaymentTime) {
        this.orderPaymentTime = orderPaymentTime == null ? null : orderPaymentTime.trim();
    }

    public String getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(String orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime == null ? null : orderUpdateTime.trim();
    }

	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}