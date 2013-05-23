package com.ht.scada.common.tag.util;

/**
 * 索引类型
 * @author 赵磊
 *
 */
public enum MajorTagTypeEnum {
	CHANG_LEVEL("厂"), KUANG_LEVEL("矿"),DUI_LEVEL("队");
	
	private String value;

	private MajorTagTypeEnum(String value) {
		this.value = value;
	}

	private MajorTagTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static MajorTagTypeEnum getByValue(String value) {
		for (MajorTagTypeEnum type : MajorTagTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
