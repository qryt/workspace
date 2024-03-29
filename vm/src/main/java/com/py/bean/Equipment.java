package com.py.bean;

import java.util.Date;
import java.util.List;

public class Equipment {
    private Integer equipmentId;

    private Integer equipmentPointId;

    private String equipmentName;

    private String equipmentNumber;

    private Integer equipmentClassifyId;

    private Integer equipmentStatus;

    private String equipmentStatusInformation;

    private String equipmentWirelessUpgrade;

    private String equipmentLegalInformation;

    private String equipmentNote;

    private String equipmentIp;

    private String equipmentAndroidVersion;

    private String equipmentAndroidSecurityPatchLevel;

    private String equipmentBasebandVersion;

    private String equipmentKernelVersion;

    private String equipmentVersionNumber;

    private Double equipmentLongitude;

    private Double equipmentLatitude;

    private String equipmentSocketKey;

    private Date equipmentCreateTime;

    private Date equipmentChangeTime;

    private EquipmentMessage equipmentMessage;
    
    private List<Sideboard> sideboards;
    
    private EquipmentClassify equipmentClassify;
    
    private List<Aisle> aisles;
    
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getEquipmentPointId() {
        return equipmentPointId;
    }

    public void setEquipmentPointId(Integer equipmentPointId) {
        this.equipmentPointId = equipmentPointId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
    }

    public Integer getEquipmentClassifyId() {
        return equipmentClassifyId;
    }

    public void setEquipmentClassifyId(Integer equipmentClassifyId) {
        this.equipmentClassifyId = equipmentClassifyId;
    }

    public Integer getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(Integer equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentStatusInformation() {
        return equipmentStatusInformation;
    }

    public void setEquipmentStatusInformation(String equipmentStatusInformation) {
        this.equipmentStatusInformation = equipmentStatusInformation == null ? null : equipmentStatusInformation.trim();
    }

    public String getEquipmentWirelessUpgrade() {
        return equipmentWirelessUpgrade;
    }

    public void setEquipmentWirelessUpgrade(String equipmentWirelessUpgrade) {
        this.equipmentWirelessUpgrade = equipmentWirelessUpgrade == null ? null : equipmentWirelessUpgrade.trim();
    }

    public String getEquipmentLegalInformation() {
        return equipmentLegalInformation;
    }

    public void setEquipmentLegalInformation(String equipmentLegalInformation) {
        this.equipmentLegalInformation = equipmentLegalInformation == null ? null : equipmentLegalInformation.trim();
    }

    public String getEquipmentNote() {
        return equipmentNote;
    }

    public void setEquipmentNote(String equipmentNote) {
        this.equipmentNote = equipmentNote == null ? null : equipmentNote.trim();
    }

    public String getEquipmentIp() {
        return equipmentIp;
    }

    public void setEquipmentIp(String equipmentIp) {
        this.equipmentIp = equipmentIp == null ? null : equipmentIp.trim();
    }

    public String getEquipmentAndroidVersion() {
        return equipmentAndroidVersion;
    }

    public void setEquipmentAndroidVersion(String equipmentAndroidVersion) {
        this.equipmentAndroidVersion = equipmentAndroidVersion == null ? null : equipmentAndroidVersion.trim();
    }

    public String getEquipmentAndroidSecurityPatchLevel() {
        return equipmentAndroidSecurityPatchLevel;
    }

    public void setEquipmentAndroidSecurityPatchLevel(String equipmentAndroidSecurityPatchLevel) {
        this.equipmentAndroidSecurityPatchLevel = equipmentAndroidSecurityPatchLevel == null ? null : equipmentAndroidSecurityPatchLevel.trim();
    }

    public String getEquipmentBasebandVersion() {
        return equipmentBasebandVersion;
    }

    public void setEquipmentBasebandVersion(String equipmentBasebandVersion) {
        this.equipmentBasebandVersion = equipmentBasebandVersion == null ? null : equipmentBasebandVersion.trim();
    }

    public String getEquipmentKernelVersion() {
        return equipmentKernelVersion;
    }

    public void setEquipmentKernelVersion(String equipmentKernelVersion) {
        this.equipmentKernelVersion = equipmentKernelVersion == null ? null : equipmentKernelVersion.trim();
    }

    public String getEquipmentVersionNumber() {
        return equipmentVersionNumber;
    }

    public void setEquipmentVersionNumber(String equipmentVersionNumber) {
        this.equipmentVersionNumber = equipmentVersionNumber == null ? null : equipmentVersionNumber.trim();
    }

    public Double getEquipmentLongitude() {
        return equipmentLongitude;
    }

    public void setEquipmentLongitude(Double equipmentLongitude) {
        this.equipmentLongitude = equipmentLongitude;
    }

    public Double getEquipmentLatitude() {
        return equipmentLatitude;
    }

    public void setEquipmentLatitude(Double equipmentLatitude) {
        this.equipmentLatitude = equipmentLatitude;
    }

    public String getEquipmentSocketKey() {
        return equipmentSocketKey;
    }

    public void setEquipmentSocketKey(String equipmentSocketKey) {
        this.equipmentSocketKey = equipmentSocketKey == null ? null : equipmentSocketKey.trim();
    }

    public Date getEquipmentCreateTime() {
        return equipmentCreateTime;
    }

    public void setEquipmentCreateTime(Date equipmentCreateTime) {
        this.equipmentCreateTime = equipmentCreateTime;
    }

    public Date getEquipmentChangeTime() {
        return equipmentChangeTime;
    }

    public void setEquipmentChangeTime(Date equipmentChangeTime) {
        this.equipmentChangeTime = equipmentChangeTime;
    }

	public EquipmentMessage getEquipmentMessage() {
		return equipmentMessage;
	}

	public void setEquipmentMessage(EquipmentMessage equipmentMessage) {
		this.equipmentMessage = equipmentMessage;
	}

	public List<Sideboard> getSideboards() {
		return sideboards;
	}

	public void setSideboards(List<Sideboard> sideboards) {
		this.sideboards = sideboards;
	}

	public EquipmentClassify getEquipmentClassify() {
		return equipmentClassify;
	}

	public void setEquipmentClassify(EquipmentClassify equipmentClassify) {
		this.equipmentClassify = equipmentClassify;
	}

	public List<Aisle> getAisles() {
		return aisles;
	}

	public void setAisles(List<Aisle> aisles) {
		this.aisles = aisles;
	}
}