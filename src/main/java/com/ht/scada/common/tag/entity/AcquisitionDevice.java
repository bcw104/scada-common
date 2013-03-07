package com.ht.scada.common.tag.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 采集设备(RTU)<br>
 * 用于定义采集设备的基本信息
 * @author 薄成文
 *
 */
@Entity
@Table(name="T_Acquisition_Device")
public class AcquisitionDevice extends AbstractDevice {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1515318803542455615L;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean used;		// 启用
	
	private int address;		// 通讯地址
	private int timeout;		// 通讯超时（ms）
	private int retry;			// 重发
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="channel_id")
	private AcquisitionChannel channel;
	
	@OneToMany(mappedBy="rtuDevice")
	private List<SensorDevice> sensorDevices;
	
	public AcquisitionDevice() {
	}
	
	public AcquisitionDevice(Integer id) {
		setId(id);
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
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
	
	public List<SensorDevice> getSensorDevices() {
		return sensorDevices;
	}
	
	public void setSensorDevices(List<SensorDevice> sensorDevices) {
		this.sensorDevices = sensorDevices;
	}
}
