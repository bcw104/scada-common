package com.ht.scada.common.data.entity;

import java.util.Date;

import com.ht.scada.common.user.entity.User;

/**
 * 故障诊断记录
 * @author 薄成文
 *
 */
public class FaultDiagnoseRecord {

	private String id; // 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 故障类型
	private String info;// 故障信息
	private Integer level;	// 故障程度 
	private Date actionTime;
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
