package com.ht.scada.common.tag.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 传感器设备
 * @author 薄成文
 *
 */
@Entity
@Table(name="T_Sensor_Device")
public class SensorDevice extends AbstractDevice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215030492033268594L;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rtu_device_id")
	private AcquisitionDevice rtuDevice;

	public AcquisitionDevice getRtuDevice() {
		return rtuDevice;
	}

	public void setRtuDevice(AcquisitionDevice rtuDevice) {
		this.rtuDevice = rtuDevice;
	}
	
}
