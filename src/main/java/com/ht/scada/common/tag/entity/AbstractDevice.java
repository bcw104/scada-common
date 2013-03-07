package com.ht.scada.common.tag.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public abstract class AbstractDevice extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1639093467956500056L;
	private String name; // 设备名称
	private String manufacture; // 生产厂家
	private String type; // 设备型号
	@Temporal(TemporalType.DATE)
	private Date fixTime; // 安装日期
	private String fixPositin; // 安装位置
	private String remark; // 备注

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getFixTime() {
		return fixTime;
	}

	public void setFixTime(Date fixTime) {
		this.fixTime = fixTime;
	}

	public String getFixPositin() {
		return fixPositin;
	}

	public void setFixPositin(String fixPositin) {
		this.fixPositin = fixPositin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
