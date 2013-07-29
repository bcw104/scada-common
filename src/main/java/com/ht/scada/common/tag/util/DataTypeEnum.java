package com.ht.scada.common.tag.util;

public enum DataTypeEnum {
	BOOL("布尔型"), INT32("整型32位"), INT16("整型16位"), BCD("BCD码"), MOD10000("MOD10000"), FLOAT("浮点型32位"), DOUBLE("双浮点型64位"), ASCII("ASCII码"), /* 遥测数组  */INT16_ARRAY("双字节数组");
	
	private String value;

	private DataTypeEnum(String value) {
		this.value = value;
	}

	private DataTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static DataTypeEnum getByValue(String value) {
		for (DataTypeEnum type : DataTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
