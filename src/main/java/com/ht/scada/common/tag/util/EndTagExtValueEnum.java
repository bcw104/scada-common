package com.ht.scada.common.tag.util;


/**
 * 监控对象扩展属性值
 * @author 赵磊
 *
 */
public enum EndTagExtValueEnum {
	ZI_PEN("自喷"),
	ZHU_QI("注汽"),
	MEN_JING("焖井"),
	CHOU_YOU("抽油"),
	
	XI_YOU("稀油"),
	CHOU_YOU_JING("稠油");

	private String value;

	private EndTagExtValueEnum(String value) {
		this.value = value;
	}

	private EndTagExtValueEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static EndTagExtValueEnum getByValue(String value) {
		for (EndTagExtValueEnum type : EndTagExtValueEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
