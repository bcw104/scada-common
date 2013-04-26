package com.ht.scada.common.tag.well.consts;
/**
 * 油井子类型
 * @author 赵磊
 *
 */
public enum EndTagSubType {
	YOU_LIANG_SHI("油梁式"),DIAN_GUN_TONG("电滚筒"),GAO_YUAN_JI("高原机"),LUO_GAN_BENG("螺杆泵"),DIAN_QIAN_BENG("电潜泵");
	
	private String value;
	
	private EndTagSubType(String value) {
		this.value = value;
	}
	private EndTagSubType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
	
	public static EndTagSubType getByValue(String value) {
		for(EndTagSubType type : EndTagSubType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
