package com.ht.scada.common.tag.entity;


import java.util.HashMap;
import java.util.Map;

public class TransformerMD {
	private String name;
	private boolean	used = true; 	// 是否按契约限额计费
	private double 	capacity = 1600; 		// 变压器容量
	private double 	md = 800; 			// 契约限额
	
	private Map<Integer, Double> monthMDMap = new HashMap<Integer, Double>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getMd() {
		return md;
	}

	public void setMd(double md) {
		this.md = md;
	}

	public Map<Integer, Double> getMonthMDMap() {
		return monthMDMap;
	}
	
	public void setMonthMDMap(Map<Integer, Double> monthMDMap) {
		this.monthMDMap = monthMDMap;
	}
}
