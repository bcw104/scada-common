package com.ht.scada.common.tag.util;

import com.ht.scada.common.tag.exception.PortInfoErrorException;

/**
 * 端口信息解析工具类
 * 用于解析{@link com.ht.scada.common.tag.entity.AcquisitionChannel AcquisitionChannel}中的端口信息[portInfo]<br>
 * 包括：TCP/IP通讯的物理信息、DTU通讯的物理信息、 串口通讯通讯的物理信息
 * @author 薄成文
 */
public class PortInfoFactory {
	
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
				String dtuId = infoArray[0];
				int port = Integer.parseInt(infoArray[1]);
				String heartBeat = infoArray[2];
				int heartBeatInterval = Integer.parseInt(infoArray[3]);
				
				DtuInfo dtuInfo = new DtuInfo(dtuId, port, heartBeat, heartBeatInterval);
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
				String ip = infoArray[0];
				int port = Integer.parseInt(infoArray[1]);
				TcpIpInfo tcpIpInfo = new TcpIpInfo(ip, port);
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
				int port = Integer.parseInt(infoArray[0]);
				int baud = Integer.parseInt(infoArray[1]);
				int dataBit = Integer.parseInt(infoArray[2]);
				String parity = infoArray[3];
				String stopBit = infoArray[4];
				SerialInfo serialInfo = new SerialInfo(port, baud, dataBit, parity, stopBit);
				return serialInfo;
			} catch (NumberFormatException e) {
				throw new PortInfoErrorException("无法按照Serial格式解析:"+portInfo + "," + e.getMessage());
			}
		} else {
			throw new PortInfoErrorException("无法按照Serial格式解析:"+portInfo);
		}
	}
	
	public static class TcpIpInfo {
		public String ip;
		public int port;
		private TcpIpInfo(String ip, int port) {
			this.ip = ip;
			this.port = port;
		}
		
	}
	
	public static class SerialInfo {
		public int port;// 端口1、2、3、4...
		public int baud;// 波特率
		public int dataBit;
		public String parity;
		public String stopBit;
		
		private SerialInfo(int port, int baud, int dataBit, String parity,
				String stopBit) {
			this.port = port;
			this.baud = baud;
			this.dataBit = dataBit;
			this.parity = parity;
			this.stopBit = stopBit;
		}
		
	}
	

	public static class DtuInfo {
		public String dtuId;
		public int port;
		public String heartBeat;
		public int heartBeatInterval;
		private DtuInfo(String dtuId, int port, String heartBeat,
				int heartBeatInterval) {
			this.dtuId = dtuId;
			this.port = port;
			this.heartBeat = heartBeat;
			this.heartBeatInterval = heartBeatInterval;
		}
		
	}
}
