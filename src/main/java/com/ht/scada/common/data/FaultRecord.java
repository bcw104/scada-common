package com.ht.scada.common.data;

import java.util.Date;

/**
 * 遥测数据记录
 * @author 薄成文
 *
 */
public class FaultRecord {
	
	private String id;	// 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 变量名称
	private String group;
	private String info;// 故障信息
	private boolean value;
	private Date actionTime;
	private Date resumeTime;

	public FaultRecord() {
	}
	
	public FaultRecord(String code, String name, String group, String info, boolean value, Date actionTime) {
		this.code = code;
		this.name = name;
		this.group = group;
		this.info = info;
		this.value = value;
		this.actionTime = actionTime;
	}
	
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public Date getResumeTime() {
		return resumeTime;
	}

	public void setResumeTime(Date resumeTime) {
		this.resumeTime = resumeTime;
	}
	
}
