package com.ht.scada.common.tag.util;

/**
 * 变量类型
 * @author 赵磊
 */
public enum VarTypeEnum {
	YX("遥信"), YC("遥测"), YM("遥脉"), YK("遥控"), YT("遥调"), /** 其它 **/QT("其他");
	
	private String value;

	private VarTypeEnum(String value) {
		this.value = value;
	}

	private VarTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static VarTypeEnum getByValue(String value) {
		for (VarTypeEnum type : VarTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
