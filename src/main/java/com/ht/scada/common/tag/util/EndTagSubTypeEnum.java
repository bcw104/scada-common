package com.ht.scada.common.tag.util;

/**
 * 监控对象子类型
 * 
 * @author 赵磊
 * 
 */
public enum EndTagSubTypeEnum {
	YOU_LIANG_SHI("油梁式"), DIAN_GUN_TONG("电滚筒"), GAO_YUAN_JI("高原机"), LUO_GAN_BENG(
			"螺杆泵"), DIAN_QIAN_BENG("电潜泵");

	private String value;

	private EndTagSubTypeEnum(String value) {
		this.value = value;
	}

	private EndTagSubTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static EndTagSubTypeEnum getByValue(String value) {
		for (EndTagSubTypeEnum type : EndTagSubTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
