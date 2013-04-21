package com.ht.scada.common.tag.well.consts;

/**
 * 主索引类型
 * @author 赵磊
 *
 */
public enum MajorTagType {
	CHANG_LEVEL("厂"),KUANG_LEVEL("矿"),DUI_LEVEL("队");
	
	private String value;
	
	private MajorTagType(String value) {
		this.value = value;
	}
	private MajorTagType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
	public static MajorTagType getByValue(String value) {
		for(MajorTagType type : MajorTagType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
