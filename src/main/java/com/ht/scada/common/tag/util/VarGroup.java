package com.ht.scada.common.tag.util;

/**
 * 变量分组
 * 
 * @author 薄成文
 * @author 赵磊
 * @deprecated
 * @see com.ht.scada.common.tag.varGroupCfg
 */
public enum VarGroup {
	DIAN_YC("电力数据"), DIAN_YM("电能数据"), DIAN_XB("谐波"), YOU_JING("油井"), YOU_JING_SGT(
			"示功图"), YOU_JING_DGT("电功图"), SHUI_JING("水井"), JI_LIANG("计量车"), ZHU_CAI(
			"注采");

	private String value;

	private VarGroup(String value) {
		this.value = value;
	}

	private VarGroup() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static VarGroup getByValue(String value) {
		for (VarGroup type : VarGroup.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
