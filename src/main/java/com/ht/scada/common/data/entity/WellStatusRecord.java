package com.ht.scada.common.data.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class WellStatusRecord extends AbstractPersistable<Integer> {
	
	private String code;
	//private boolean status;
	private Date startTime;
	private Date stopTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

}
