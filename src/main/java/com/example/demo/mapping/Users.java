package com.example.demo.mapping;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3807392371096832616L;
	// 用户id
//	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(nullable = false, name = "id")
	private Long id;
	// 创建时间
	// @Column(nullable = false, name = "creat_time")
	private Date creatTime;
	// 手机号
	// @Column(nullable = false, name = "phone_number")
	private String phoneNumber;
	// 密码
	// @Column(nullable = false, name = "password")
	private String password;
	// 是否使用 1=使用中 2=停用
	// @Column(nullable = false, name = "is_enable ")
	private Byte enableFlag;
	// 登录时间
	// @Column(nullable = false, name = "login_time")
	private Date loginTime;
	// 登录ip地址
	// @Column(nullable = false, name = "login_ip")
	private String loginIp;
	// 登录次数
	// @Column(nullable = false, name = "login_count")
	private Integer loginCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Byte getEnableFlag() {
		return enableFlag;

	}

	public void setEnableFlag(Byte enableFlag) {
		this.enableFlag = enableFlag;

	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
}