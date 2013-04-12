package com.ht.scada.common.well;

import java.util.Date;

/**
 * 油井启停状态
 * @author 薄成文
 *
 */
public class WellStatus {
	private String code;
	/**
	 * 启停井状态<br>
	 * 1:启动 0：停止 -1：未知
	 */
	private int status;

	/**
	 * 操作时间，精确到秒
	 */
	private Date datetime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
