package com.py.bean;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminAccount;

    private String adminPassword;

    private String adminRealname;

    private String adminPhonenum;

    private String adminEmail;

    private String adminRegistrationId;

    private Integer adminRegistrationType;

    private String adminPosition;

    private Date adminPositionTime;

    private Date adminCreationTime;
    
    private Role role;
    
    private Point point;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount == null ? null : adminAccount.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminRealname() {
        return adminRealname;
    }

    public void setAdminRealname(String adminRealname) {
        this.adminRealname = adminRealname == null ? null : adminRealname.trim();
    }

    public String getAdminPhonenum() {
        return adminPhonenum;
    }

    public void setAdminPhonenum(String adminPhonenum) {
        this.adminPhonenum = adminPhonenum;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    public String getAdminRegistrationId() {
        return adminRegistrationId;
    }

    public void setAdminRegistrationId(String adminRegistrationId) {
        this.adminRegistrationId = adminRegistrationId == null ? null : adminRegistrationId.trim();
    }

    public Integer getAdminRegistrationType() {
        return adminRegistrationType;
    }

    public void setAdminRegistrationType(Integer adminRegistrationType) {
        this.adminRegistrationType = adminRegistrationType;
    }

    public String getAdminPosition() {
        return adminPosition;
    }

    public void setAdminPosition(String adminPosition) {
        this.adminPosition = adminPosition == null ? null : adminPosition.trim();
    }

    public Date getAdminPositionTime() {
        return adminPositionTime;
    }

    public void setAdminPositionTime(Date adminPositionTime) {
        this.adminPositionTime = adminPositionTime;
    }

    public Date getAdminCreationTime() {
        return adminCreationTime;
    }

    public void setAdminCreationTime(Date adminCreationTime) {
        this.adminCreationTime = adminCreationTime;
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}