package com.ht.scada.common.data;

import java.util.Date;

/**
 * 遥测越限记录
 * @author 薄成文
 *
 */
public class OffLimitsRecord {
	private String id;	// 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 变量名称
	private String group;
	private String info;// 报警信息
	private double value;// 动作值
	private double threshold;// 阈值
	private boolean type;// 越限类型 true:越上限，false:越下限 
	private Date actionTime;
	private Date resumeTime;

	public OffLimitsRecord() {
	}

	public OffLimitsRecord(String code, String name, String group, String info, double value,
			double threshold, boolean type, Date actionTime) {
		this.code = code;
		this.name = name;
		this.group = group;
		this.info = info;
		this.value = value;
		this.threshold = threshold;
		this.type = type;
		this.actionTime = actionTime;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
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
