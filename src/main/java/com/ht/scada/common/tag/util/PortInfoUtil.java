package com.ht.scada.common.tag.util;

import com.ht.scada.common.tag.exception.PortInfoErrorException;

/**
 * 端口信息解析工具类
 * 用于解析{@link com.ht.scada.common.tag.entity.AcquisitionChannel AcquisitionChannel}中的端口信息[portInfo]<br>
 * 包括：TCP/IP通讯的物理信息、DTU通讯的物理信息、 串口通讯通讯的物理信息
 * @author 薄成文
 */
public class PortInfoUtil {
	public static final String DTU_INFO_PREFIX = "dtu";
	public static DtuInfo parseDtuInfo(String portInfo) throws PortInfoErrorException {
		if (portInfo.startsWith("dtu|")) {
			String[] infoArray = portInfo.substring(4).split(":");
			if (infoArray.length != 4) {
				throw new PortInfoErrorException("DTU信息不完整:"+portInfo);
			}
			
			for (String info : infoArray) {
				if (info.isEmpty()) {
					throw new PortInfoErrorException("DTU信息不完整:"+portInfo);
				}
			}
			
			try {
				DtuInfo dtuInfo = new DtuInfo();
				dtuInfo.setDtuId(infoArray[0]);
				dtuInfo.setPort(Integer.parseInt(infoArray[1]));
				dtuInfo.setHeartBeat(infoArray[2]);
				dtuInfo.setHeartBeatInterval(Integer.parseInt(infoArray[3]));
				
				return dtuInfo;
			} catch (NumberFormatException e) {
				throw new PortInfoErrorException("无法按照DTU格式解析:"+portInfo + "," + e.getMessage());
			}
		} else {
			throw new PortInfoErrorException("无法按照DTU格式解析:"+portInfo);
		}
	}
	
	/**
	 * @param portInfo
	 * @return
	 * @throws PortInfoErrorException
	 */
	public static TcpIpInfo parseTcpIpInfo(String portInfo) throws PortInfoErrorException {
		if (portInfo.startsWith("tcp/ip|")) {
			String[] infoArray = portInfo.substring(7).split(":");
			if (infoArray.length != 2) {
				throw new PortInfoErrorException("TCP信息不完整:"+portInfo);
			}
			
			for (String info : infoArray) {
				if (info.isEmpty()) {
					throw new PortInfoErrorException("TCP信息不完整:"+portInfo);
				}
			}
			
			try {
				TcpIpInfo tcpIpInfo = new TcpIpInfo();
				tcpIpInfo.setIp(infoArray[0]);
				tcpIpInfo.setPort(Integer.parseInt(infoArray[1]));
				return tcpIpInfo;
			} catch (NumberFormatException e) {
				throw new PortInfoErrorException("无法按照TCP格式解析:"+portInfo + "," + e.getMessage());
			}
		} else {
			throw new PortInfoErrorException("无法按照TCP格式解析:"+portInfo);
		}
	}
	
	/**
	 * 解析串口端口信息<br>
	 * 信息格式:	【通讯方式】|【端口】：【波特率】:【数据位(5/6/7/8)】:【校验位(无/奇/偶)】:【停止位(1/1.5/2)】<br>
	 * 例如：		serial|1:9600:8:无:1<br>
	 * @param portInfo
	 * @return
	 * @throws PortInfoErrorException
	 */
	public static SerialInfo parseSerialInfo(String portInfo) throws PortInfoErrorException {
		if (portInfo.startsWith("serial|")) {
			String[] infoArray = portInfo.substring(7).split(":");
			if (infoArray.length != 5) {
				throw new PortInfoErrorException("Serial信息不完整:"+portInfo);
			}
			
			for (String info : infoArray) {
				if (info.isEmpty()) {
					throw new PortInfoErrorException("Serial信息不完整:"+portInfo);
				}
			}
			
			try {
				SerialInfo serialInfo = new SerialInfo();
				serialInfo.setPort(Integer.parseInt(infoArray[0]));
				serialInfo.setBaud(Integer.parseInt(infoArray[1]));
				serialInfo.setDataBit(Integer.parseInt(infoArray[2]));
				serialInfo.setParity(infoArray[3]);
				serialInfo.setStopBit(infoArray[4]);
				return serialInfo;
			} catch (NumberFormatException e) {
				throw new PortInfoErrorException("无法按照Serial格式解析:"+portInfo + "," + e.getMessage());
			}
		} else {
			throw new PortInfoErrorException("无法按照Serial格式解析:"+portInfo);
		}
	}
}
