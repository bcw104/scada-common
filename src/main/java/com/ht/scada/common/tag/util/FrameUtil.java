package com.ht.scada.common.tag.util;

import java.util.ArrayList;
import java.util.List;

import com.ht.scada.common.tag.exception.FrameInfoErrorException;
import com.ht.scada.common.tag.exception.PortInfoErrorException;

public class FrameUtil {
	
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
				String priority = frameInfoArray[2];
				String name = null;
				if (frameInfoArray.length == 4) {
					name = frameInfoArray[3];
				}
				
				if (slaveInfo.isEmpty() || regInfo.isEmpty() || priority.isEmpty()) {
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
				
				ModbusFrame modbusFrame = new ModbusFrame();
				modbusFrame.setSlave(slave);
				modbusFrame.setFunCode(Integer.parseInt(regInfoArray[0]));
				modbusFrame.setStart(Integer.parseInt(regInfoArray[1]));
				modbusFrame.setLen(Integer.parseInt(regInfoArray[2]));
				modbusFrame.setPriority(Integer.parseInt(priority));
				modbusFrame.setName(name);
				
				return modbusFrame;
			} catch (Exception e) {
				throw new FrameInfoErrorException("modbus帧格式错误：" + frame);
			}
		}
	}
}
