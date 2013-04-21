package com.ht.scada.common.data.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class WellDailyCompositeInfo extends AbstractPersistable<Integer> {

	/**
	 * 油井编号
	 */
	private String code;
	
	/**
	 * 精确到日
	 */
	private Date date;
}
