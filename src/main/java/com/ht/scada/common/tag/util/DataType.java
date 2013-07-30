package com.ht.scada.common.tag.util;

public enum DataType {
	BOOL("布尔型"), BYTE_H("高字节"), BYTE_L("低字节"), INT32("整型32位"), INT16("整型16位"), BCD("BCD码"), MOD10000("MOD10000"), FLOAT("浮点型32位"), DOUBLE("双浮点型64位"), /* 遥测数组  */INT16_ARRAY("双字节数组");
	
	private String value;

	private DataType(String value) {
		this.value = value;
	}

	private DataType() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static DataType getByValue(String value) {
		for (DataType type : DataType.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
