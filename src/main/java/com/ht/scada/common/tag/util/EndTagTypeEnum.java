package com.ht.scada.common.tag.util;

/**
 * 末端节点类型
 * 
 * @author 赵磊
 * 
 */
public enum EndTagTypeEnum {
	YOU_JING("油井"), SHUI_YUAN_JING("水源井"), ZHU_SHUI_JING("注水井"), ZENG_YA_ZHAN(
			"增压站"), ZHU_QI_ZHAN("注汽站"), LIAN_HE_ZHAN("联合站"), JIE_ZHUAN_ZHAN(
			"接转站"), ZHU_SHUI_ZHAN("注水站"), JI_LIANG_ZHAN("计量站"), PEI_SHUI_JIAN(
			"配水间"), JI_LIANG_CHE("计量车");

	private String value;

	private EndTagTypeEnum(String value) {
		this.value = value;
	}

	private EndTagTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static EndTagTypeEnum getByValue(String value) {
		for (EndTagTypeEnum type : EndTagTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
