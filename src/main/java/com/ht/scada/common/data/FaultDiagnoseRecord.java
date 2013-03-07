package com.ht.scada.common.data;

import java.util.Date;

public class FaultDiagnoseRecord {

	private String id; // 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 故障类型
	private String info;// 故障信息
	private Date actionTime;

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

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

}
