package com.ht.scada.common.tag.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="T_Acquisition_Device")
public class AcquisitionDevice extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1862181868146336123L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;		// 设备名称
	private String manufacture;	// 生产厂家
	private String type;		// 设备型号
	@Temporal(TemporalType.DATE)
	private Date fixTime;		// 安装日期
	private String fixPositin;	// 安装位置
	private String remark;		// 备注
	private int pt;				// 电压变比
	private int ct;				// 电流变化
	
	private String address;		// 通讯地址
	private int timeout;		// 通讯超时（ms）
	private int retry;			// 重发
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean used;		// 启用
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="channel_id")
	private AcquisitionChannel channel;
	
	public AcquisitionDevice() {
	}
	
	public AcquisitionDevice(Integer id) {
		setId(id);
	}

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

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public AcquisitionChannel getChannel() {
		return channel;
	}

	public void setChannel(AcquisitionChannel channel) {
		this.channel = channel;
	}
	
	
}
