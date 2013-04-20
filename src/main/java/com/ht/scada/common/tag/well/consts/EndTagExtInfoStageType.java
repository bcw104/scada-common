package com.ht.scada.common.tag.well.consts;

/**
 * 油井阶段
 * @author 赵磊
 *
 */
public enum EndTagExtInfoStageType {
	ZI_PEN("自喷"),ZHU_QI("注汽"),MEN_JING("焖井"),CHOU_YOU("抽油");
	
	private String value;
	
	private EndTagExtInfoStageType(String value) {
		this.value = value;
	}
	private EndTagExtInfoStageType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
}
