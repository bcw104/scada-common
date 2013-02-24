package com.ht.scada.common.data;

import java.util.Date;

/**
 * 遥脉数据记录
 * @author 薄成文
 *
 */
public class YMData {
	private String code;// 计量点编号(回路号、井号等)
	private String name;
	private double value;
	private double change;
	private Date datetime;

	public YMData() {
	}

	public YMData(String code, String name, double value, double change,
			Date datetime) {
		this.code = code;
		this.name = name;
		this.value = value;
		this.change = change;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
