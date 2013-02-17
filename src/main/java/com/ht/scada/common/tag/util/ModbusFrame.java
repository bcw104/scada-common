package com.ht.scada.common.tag.util;

public class ModbusFrame {

	private String name;
	private int[][] slave;
	private int priority = 0;
	private int funCode = 3;
	private int start = 0;
	private int len;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[][] getSlave() {
		return slave;
	}

	public void setSlave(int[][] slave) {
		this.slave = slave;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getFunCode() {
		return funCode;
	}

	public void setFunCode(int funCode) {
		this.funCode = funCode;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

}
