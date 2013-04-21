package com.ht.scada.common.data;

import java.util.Date;

/**
 * 遥测数据记录
 * @author 薄成文
 *
 */
public class YCData {
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 变量名称
	private String group;// 变量分组
	private double value;
	private Date datetime;

	public YCData() {
	}

	public YCData(String code, String name, String group, double value, Date datetime) {
		this.code = code;
		this.name = name;
		this.group = group;
		this.value = value;
		this.datetime = datetime;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
