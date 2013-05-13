package com.ht.scada.common.tag.util;

import com.ht.scada.common.tag.exception.FrameInfoErrorException;

import java.util.ArrayList;
import java.util.List;

public class ChannelFrameFactory {
	
	public static List<ModbusFrame> parseModbusFrames(String frames) throws FrameInfoErrorException {
		List<ModbusFrame> list = new ArrayList<>();
		String[] frameArray = frames.split(",");
		for (String frame : frameArray) {
			ModbusFrame modbusFrame = parseModbusFrame(frame);
			list.add(modbusFrame);
		}
		return list;
	}
	
	private static ModbusFrame parseModbusFrame(String frame) throws FrameInfoErrorException {
		String[] frameInfoArray = frame.split("\\|");
		if (frameInfoArray.length != 3 && frameInfoArray.length != 4) {
			throw new FrameInfoErrorException("modbus帧格式错误：" + frame);
		} else {
			try {
				String slaveInfo = frameInfoArray[0];
				String regInfo = frameInfoArray[1];
				String name = null;
				if (frameInfoArray.length == 4) {
					name = frameInfoArray[3];
				}
				
				if (slaveInfo.isEmpty() || regInfo.isEmpty() || frameInfoArray[2].isEmpty()) {
					throw new FrameInfoErrorException("modbus帧格式错误：" + frame);
				}
				
				// 解析从站地址
				String[] slaveArray = slaveInfo.split("\\s");
				int[][] slave = new int[slaveArray.length][2];
				for (int i = 0; i < slaveArray.length; i++) {
					String[] slaveSubArray = slaveArray[i].split("\\-");
					for (int j = 0; j < slaveSubArray.length; j++) {
						slave[i][j] = Integer.parseInt(slaveSubArray[j]);
					}
				}
				
				String[] regInfoArray = regInfo.split("\\-");
				if (regInfoArray.length != 3) {
					throw new FrameInfoErrorException("modbus帧格式错误：" + frame);
				}
				
				int funCode = Integer.parseInt(regInfoArray[0]);
				int start = Integer.parseInt(regInfoArray[1]);
				int len = Integer.parseInt(regInfoArray[2]);
				int interval = Integer.parseInt(frameInfoArray[2]);
				ModbusFrame modbusFrame = new ModbusFrame(name, slave, interval, funCode, start, len);
				return modbusFrame;
			} catch (Exception e) {
				throw new FrameInfoErrorException("modbus帧格式错误：" + frame);
			}
		}
	}
	
	public static List<IEC104Frame> parseIEC104Frames(String frames) throws FrameInfoErrorException {
		List<IEC104Frame> list = new ArrayList<>();
		String[] frameArray = frames.split(",");
		for (String frame : frameArray) {
			IEC104Frame iecFrame = parseIEC104Frame(frame);
			list.add(iecFrame);
		}
		return list;
	}
	
	private static IEC104Frame parseIEC104Frame(String frame) throws FrameInfoErrorException {
		String[] frameInfoArray = frame.split("\\|");
		if (frameInfoArray.length != 1 && frameInfoArray.length != 2) {
			throw new FrameInfoErrorException("iec104帧格式错误：" + frame);
		} else {
			try {
				//IEC104FrameType type = IEC104FrameType.valueOf(frameInfoArray[0].toUpperCase());
				String name = null;
				if (frameInfoArray.length == 2) {
					name = frameInfoArray[1];
				}
				String[] subArray = frameInfoArray[0].split("\\-");
				int type = 0;
				if (subArray[0].startsWith("0x") || subArray[0].startsWith("0X")) {
					type = Integer.parseInt(subArray[0].substring(2), 16);
				} else {
					type = Integer.parseInt(subArray[0]);
				}
				int interval = Integer.parseInt(subArray[1]);
				IEC104Frame iecFrame = new IEC104Frame(type, interval, name);
				return iecFrame;
			} catch (Exception e) {
				throw new FrameInfoErrorException("iec104帧格式错误：" + frame);
			}
		}
	}
	
	public static class ModbusFrame {

		public String name;
		public int[][] slave;
        /**
         * 执行间隔（ms）
         */
		public int interval;
		public int funCode;
		public int start;
		public int len;
		
		private ModbusFrame(String name, int[][] slave, int interval,
				int funCode, int start, int len) {
			this.name = name;
			this.slave = slave;
			this.interval = interval;
			this.funCode = funCode;
			this.start = start;
			this.len = len;
		}
		
	}
	
	public static class IEC104Frame {
        /**
         * IEC104标识编码
         */
		public int ti;
		/**
		 * 执行间隔(s)<br/>
         * 如果是历史数据召唤帧，执行间隔表示每次历史数据召唤的时间范围
         * 如果执行间隔请设置为0, 则只在每次建立连接时执行1次召唤
		 */
		public int interval;
        /**
         * 帧名称（可以为空）
         */
		public String name;
		
		private IEC104Frame(int type, int interval, String name) {
			this.ti = type;
			this.interval = interval;
			this.name = name;
		}

	}
	
}
