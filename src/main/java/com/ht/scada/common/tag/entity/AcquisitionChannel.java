package com.ht.scada.common.tag.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ht.scada.common.tag.util.CommunicationProtocal;

/**
 * 采集通道模型<br>
 * 描述采集通道通讯规约、通讯基本参数、物理端口信息、通讯帧信息
 * @author 薄成文
 *
 */
@Entity
@Table(name="T_Acquisition_Channel ")
public class AcquisitionChannel extends AbstractPersistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5934798556825570864L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	/**
	 * 规约类型
	 * IEC104
	 * ModbusTCP
	 * ModbusRTU
	 * DL645
	 */
	private CommunicationProtocal protocal = CommunicationProtocal.IEC104;
	private int offline;// 离线阈值
	private int interval = 100;//ms
	private String schedule = "* * * * * ?";// cron 任务调度表达式(误差1秒)
	
	/**
	 * 物理信息
	 * TCP/IP 通讯方式：	【通讯方式】|【IP】:【端口】
	 * 					tcp/ip|192.168.1.110:4660
	 * DTU 通讯方式：		【通讯方式】|【DTU-ID】:【端口】:【心中信号】:【心跳信号间隔】
	 * 					dtu|2000:9815:hello:180
	 * 串口通讯方式:		【通讯方式】|【端口】：【波特率】:【数据位(5/6/7/8)】:【校验位(无/奇/偶)】:【停止位(1/1.5/2)】
	 * 					serial|1:9600:8:无:1
	 */
	private String portInfo = "10.67.111.176:4660";
	
	/**
	 * 通讯帧(modbus): 【设备地址】|【功能码】-【数据地址】-【数据长度】|【优先级】|【帧名称(可省略)】
	 * 多个通讯帧用逗号隔开, 遥控帧优先级设置为0
	 * 1|3-1-10|3|
	 * 1|3-100-10|0|soe
	 * 1-10 13-23|3-1-10|3| 设备地址从1-10, 13-23的连续地址
	 */
	@Lob
	private String frames;
	
	@OneToMany(mappedBy="channel")
	private List<AcquisitionDevice> devices;
	
	public AcquisitionChannel() {
	}
	
	public AcquisitionChannel(Integer id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommunicationProtocal getProtocal() {
		return protocal;
	}

	public void setProtocal(CommunicationProtocal protocal) {
		this.protocal = protocal;
	}

	public int getOffline() {
		return offline;
	}

	public void setOffline(int offline) {
		this.offline = offline;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPortInfo() {
		return portInfo;
	}

	public void setPortInfo(String portInfo) {
		this.portInfo = portInfo;
	}

	public String getFrames() {
		return frames;
	}

	public void setFrames(String frames) {
		this.frames = frames;
	}

	public List<AcquisitionDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<AcquisitionDevice> devices) {
		this.devices = devices;
	}
	
	
}
