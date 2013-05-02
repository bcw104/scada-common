package com.ht.scada.common.tag.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 变量子类型
 * @author 赵磊
 *
 */
public enum VarSubType {
	/*********油井*************/
	YOU_YA("油压",VarGroup.YOU_JING,VarType.YC),TAO_YA("套压",VarGroup.YOU_JING,VarType.YC), HUI_YA("回压", VarGroup.YOU_JING,VarType.YC),JING_KOU_WEN_DU("井口温度", VarGroup.YOU_JING,VarType.YC),HUI_GUAN_WEN_DU("汇管温度", VarGroup.YOU_JING,VarType.YC),QI_QING_ZHUANG_TAI("启停状态", VarGroup.YOU_JING,VarType.YX),
	
	/*********示功图**************/
	CHONG_CHENG("冲程",VarGroup.YOU_JING_SGT,VarType.YC),CHONG_CI("冲次",VarGroup.YOU_JING_SGT,VarType.YC),SHANG_XING_CHONG_CI("上行冲次",VarGroup.YOU_JING_SGT,VarType.YC),XIA_XING_CHONG_CI("下行冲次",VarGroup.YOU_JING_SGT,VarType.YC),ZUI_DA_ZAI_HE("最大载荷",VarGroup.YOU_JING_SGT,VarType.YC),ZUI_XIAO_ZAI_HE("最小载荷",VarGroup.YOU_JING_SGT,VarType.YC),WEI_YI_ARRAY("位移数组",VarGroup.YOU_JING_SGT,VarType.QT),ZAI_HE_ARRAY("载荷数组",VarGroup.YOU_JING_SGT,VarType.QT),
	/********电功图****************/
	DIAN_LIU_ARRAY("电流数组",VarGroup.YOU_JING_DGT,VarType.QT),GONG_LV_ARRAY("功率数组",VarGroup.YOU_JING_DGT,VarType.QT),GONG_LV_YIN_SHU_ARRAY("功率因数数组",VarGroup.YOU_JING_DGT,VarType.QT),DIAN_GONG_TU_ARRAY("电功图数组",VarGroup.YOU_JING_DGT,VarType.QT),
	/********电力数据*************/
	I_A("A相电流",VarGroup.DIAN_YC,VarType.YC),I_B("B相电流",VarGroup.DIAN_YC,VarType.YC),I_C("C相电流",VarGroup.DIAN_YC,VarType.YC),I_3XBPH("3相不平衡电流",VarGroup.DIAN_YC,VarType.YC),U_A("A相电压",VarGroup.DIAN_YC,VarType.YC),U_B("B相电压",VarGroup.DIAN_YC,VarType.YC),U_C("C相电压",VarGroup.DIAN_YC,VarType.YC),U_AB("AB线电压",VarGroup.DIAN_YC,VarType.YC),U_BC("BC线电压",VarGroup.DIAN_YC,VarType.YC),U_CA("CA线电压",VarGroup.DIAN_YC,VarType.YC),GV_YG("有功功率",VarGroup.DIAN_YC,VarType.YC),GV_WG("无功功率",VarGroup.DIAN_YC,VarType.YC),GV_SZ("视在功率",VarGroup.DIAN_YC,VarType.YC),GV_GLYS("功率因数",VarGroup.DIAN_YC,VarType.YC),GV_ZB("周波",VarGroup.DIAN_YC,VarType.YC),GV_YG_A("A相有功功率",VarGroup.DIAN_YC,VarType.YC),GV_YG_B("B相有功功率",VarGroup.DIAN_YC,VarType.YC),GV_YG_C("C相有功功率",VarGroup.DIAN_YC,VarType.YC),GV_WG_A("A相无功功率",VarGroup.DIAN_YC,VarType.YC),GV_WG_B("B相无功功率",VarGroup.DIAN_YC,VarType.YC),GV_WG_C("C相无功功率",VarGroup.DIAN_YC,VarType.YC),GV_SZ_A("A相视在功率",VarGroup.DIAN_YC,VarType.YC),GV_SZ_B("B相视在功率",VarGroup.DIAN_YC,VarType.YC),GV_SZ_C("C相视在功率",VarGroup.DIAN_YC,VarType.YC),GV_GVYS_A("A相功率因数",VarGroup.DIAN_YC,VarType.YC),GV_GVYS_B("B相功率因数",VarGroup.DIAN_YC,VarType.YC),GV_GVYS_C("C相功率因数",VarGroup.DIAN_YC,VarType.YC),
	
	/*******电量数据*************/
	DL_ZX_Z("正向有功总电能",VarGroup.DIAN_YM,VarType.YM),DL_ZX_J("正向有功尖时电能",VarGroup.DIAN_YM,VarType.YM),DL_ZX_F("正向有功峰时电能",VarGroup.DIAN_YM,VarType.YM),DL_ZX_P("正向有功平时电能",VarGroup.DIAN_YM,VarType.YM),DL_ZX_G("正向有功谷时电能",VarGroup.DIAN_YM,VarType.YM),DL_FX_Z("反向有功总电能",VarGroup.DIAN_YM,VarType.YM),DL_FX_J("反向有功尖时电能",VarGroup.DIAN_YM,VarType.YM),DL_FX_F("反向有功峰时电能",VarGroup.DIAN_YM,VarType.YM),DL_FX_P("反向有功平时电能",VarGroup.DIAN_YM,VarType.YM),DL_FX_G("反向有功谷时电能",VarGroup.DIAN_YM,VarType.YM),

	/********谐波数据**************/
	XB_IA("A相电流总谐波含量",VarGroup.DIAN_XB,VarType.YC),XB_IB("B相电流总谐波含量",VarGroup.DIAN_XB,VarType.YC),XB_IC("C相电流总谐波含量",VarGroup.DIAN_XB,VarType.YC),XB_UA("A相电压总谐波含量",VarGroup.DIAN_XB,VarType.YC),XB_UB("B相电压总谐波含量",VarGroup.DIAN_XB,VarType.YC),XB_UC("C相电压总谐波含量",VarGroup.DIAN_XB,VarType.YC),
	XB_IA_ARRAY("A相电流谐波数组",VarGroup.DIAN_XB,VarType.QT),
	XB_IB_ARRAY("B相电流谐波数组",VarGroup.DIAN_XB,VarType.QT),
	XB_IC_ARRAY("C相电流谐波数组",VarGroup.DIAN_XB,VarType.QT),
	XB_UA_ARRAY("A相电压谐波数组",VarGroup.DIAN_XB,VarType.QT),
	XB_UB_ARRAY("B相电压谐波数组",VarGroup.DIAN_XB,VarType.QT),
	XB_UC_ARRAY("C相电压谐波数组",VarGroup.DIAN_XB,VarType.QT),
	/********计量车**************/
	JLC_QL_SH("气量瞬时流量",VarGroup.JI_LIANG,VarType.YC),JLC_QL_LJ("气量累计流量",VarGroup.JI_LIANG,VarType.YM),JLC_YL_SH("油量瞬时流量",VarGroup.JI_LIANG,VarType.YC),JLC_YL_LJ("油量累计流量",VarGroup.JI_LIANG,VarType.YM),JLC_SL_SH("水量瞬时流量",VarGroup.JI_LIANG,VarType.YC),JLC_SL_LJ("水量累计流量",VarGroup.JI_LIANG,VarType.YM),
	JLC_HSL_SH("瞬时含水率",VarGroup.JI_LIANG,VarType.YC),JLC_WD_SH("温度",VarGroup.JI_LIANG,VarType.YC),JLC_YALI_SH("压力",VarGroup.JI_LIANG,VarType.YC),JLC_MD_SH("密度",VarGroup.JI_LIANG,VarType.YC),
	/*********注采**************/
	ZC_ZQLL_SH("蒸汽流量瞬时值",VarGroup.ZHU_CAI,VarType.YC),ZC_ZQLL_LJ("蒸汽流量累计值",VarGroup.ZHU_CAI,VarType.YM),ZC_ZQYL("蒸汽压力",VarGroup.ZHU_CAI,VarType.YC),ZC_ZQWD("蒸汽温度",VarGroup.ZHU_CAI,VarType.YC),ZC_ZQGD("蒸汽干度",VarGroup.ZHU_CAI,VarType.YC),
	;
	
	private String value;
	private VarGroup varGroup;
	private VarType varType;
	
	private VarSubType(String value) {
		this.value = value;
	}
	private VarSubType(String value, VarGroup varGroup) {
		this.value = value;
		this.varGroup = varGroup;
	}
	private VarSubType(String value, VarGroup varGroup, VarType varType) {
		this.value = value;
		this.varGroup = varGroup;
		this.varType = varType;
	}
	private VarSubType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
	
	public VarGroup getVarGroup() {
		return varGroup;
	}
	
	public VarType getVarType() {
		return varType;
	}
	/**
	 * 通过中文名获得子类型名
	 * @param value
	 * @return
	 */
	public static VarSubType getByValue(String value) {
		for(VarSubType type : VarSubType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
	/**
	 * 通过分组获得子类型列表
	 * @param group
	 * @return
	 */
	public static List<VarSubType> getVarSubTypeByGroup(String group) {
		List<VarSubType> varNameList = new ArrayList<VarSubType>();
		for(VarSubType type : VarSubType.values()) {
			if(type.getVarGroup().toString().equals(group)) {
				varNameList.add(type);
			}
		}
		return varNameList;
	}
	
	/**
	 * 通过分组获得子类型名字列表
	 * @param group
	 * @return
	 */
	public static List<String> getVarSubTypeNamesArrayByGroup(String group) {
		List<String> varNameList = new ArrayList<String>();
		for(VarSubType type : VarSubType.values()) {
			if(type.getVarGroup().toString().equals(group)) {
				varNameList.add(type.getValue());
			}
		}
		return varNameList;
	}
	
	/**
	 * 通过变量类型名字获得子类型
	 * @param varTypeName
	 * @return
	 */
	public static List<VarSubType> getVarSubTypeByVarType(String varTypeName) {
		List<VarSubType> varSubTypeList = new ArrayList<VarSubType>();
		for(VarSubType type : VarSubType.values()) {
			if(type.getVarType().toString().equals(varTypeName)) {
				varSubTypeList.add(type);
			}
		}
		return varSubTypeList;
	}
	
	public static void main(String args[]) {
		System.out.println(VarSubType.values().length);
	}

}
