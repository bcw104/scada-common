package com.ht.scada.common.data.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 逐日产液量
 * @author 薄成文
 *
 */
public class DailyOilProduct extends AbstractPersistable<Integer> {

	/**
	 * 油井编号
	 */
	private String code;

	/**
	 * 生成时间（精确到日）
	 */
	private Date datetime;

	private double value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
