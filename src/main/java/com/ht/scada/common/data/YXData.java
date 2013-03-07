package com.ht.scada.common.data;

import java.util.Date;

/**
 * 遥测数据记录
 * @author 薄成文
 *
 */
public class YXData {
	private String id;	// 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 变量名称
	private String info;
	private boolean value;
	private Date datetime;

	public YXData() {
	}

	public YXData(String code, String name, String info, boolean value, Date datetime) {
		this.code = code;
		this.name = name;
		this.info = info;
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

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
