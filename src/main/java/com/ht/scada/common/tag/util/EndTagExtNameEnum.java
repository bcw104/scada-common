package com.ht.scada.common.tag.util;


/**
 * 监控对象扩展属性名
 * @author 赵磊
 *
 */
public enum EndTagExtNameEnum {
	STAGE("油井阶段"),
	TECHNOLOGY("油井工艺"),
	BENG_JING("泵径"),
	BENG_SHENG("泵深"),
	BENG_GUA_SHEN_DU("泵挂深度"),
	HAN_SHUI_LV("含水率"),
	YOU_QI_BI("油气比"),
	MI_DU("原油密度"),
	NIAN_DU("粘度"),
	KUANG_HUA_DU("矿化度"),
	YOU_GUAN_ZU_HE("油管组合"),
	CHOU_YOU_GAN_ZU_HE("抽油杆组合");
	
	private String value;

	private EndTagExtNameEnum(String value) {
		this.value = value;
	}

	private EndTagExtNameEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	public static EndTagExtNameEnum getByValue(String value) {
		for (EndTagExtNameEnum type : EndTagExtNameEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
}
