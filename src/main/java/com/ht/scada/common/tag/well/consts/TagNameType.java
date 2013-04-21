package com.ht.scada.common.tag.well.consts;

/**
 * 变量key
 * @author 赵磊
 *
 */
public enum TagNameType {
	HUI_YA("回压"),TAO_YA("套压");
	
	
private String value;
	
	private TagNameType(String value) {
		this.value = value;
	}
	private TagNameType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
	public static TagNameType getByValue(String value) {
		for(TagNameType type : TagNameType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
