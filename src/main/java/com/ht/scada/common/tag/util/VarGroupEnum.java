package com.ht.scada.common.tag.util;

import com.ht.scada.common.tag.entity.VarGroupCfg;

/**
 * 变量分组
 * 
 * @author 薄成文
 * @author 赵磊
 */
public enum VarGroupEnum {
	DIAN_YC("电力数据"), DIAN_YM("电能数据"), DIAN_XB("谐波"), YOU_JING("油井"), YOU_JING_SGT(
			"示功图"), YOU_JING_DGT("电功图"), SHUI_JING("水井"), JI_LIANG("计量车"), ZHU_CAI(
			"注采"), RTU_ZHUANG_TAI("RTU状态"), SENSOR_RUN("传感器运行"), ZYZ_YC(
			"增压站遥测量"), ZSZ_YC("注水站遥测量"), JZZ_YC("接转站遥测量"), LHZ_YC("联合站遥测量");

	private String value;

	private VarGroupEnum(String value) {
		this.value = value;
	}

	private VarGroupEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static VarGroupEnum getByValue(String value) {
		for (VarGroupEnum type : VarGroupEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
