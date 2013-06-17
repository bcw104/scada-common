package com.ht.scada.common.tag.util;



/**
 * 变量子类型
 * 
 * @author 赵磊
 * 
 */
public enum VarSubTypeEnum {
	/********* 油井 *************/
	YOU_YA("油压"), TAO_YA("套压"), HUI_YA("回压"), JING_KOU_WEN_DU("井口温度"), HUI_GUAN_WEN_DU(
			"汇管温度"), QI_TING_ZHUANG_TAI("启停状态"),

	/********* 示功图 **************/
	CHONG_CHENG("冲程"), CHONG_CI("冲次"), SHANG_XING_CHONG_CI("上行冲次"), XIA_XING_CHONG_CI(
			"下行冲次"), ZUI_DA_ZAI_HE("最大载荷"), ZUI_XIAO_ZAI_HE("最小载荷"), WEI_YI_ARRAY(
			"位移数组"), ZAI_HE_ARRAY("载荷数组"),
			
	/******** 电功图 ****************/
	DIAN_LIU_ARRAY("电流数组"), GONG_LV_ARRAY("功率数组"), GONG_LV_YIN_SHU_ARRAY(
			"功率因数数组"), DIAN_GONG_TU_ARRAY("电功图数组"),
			
	/******** 电力数据 *************/
	I_A("A相电流"), I_B("B相电流"), I_C("C相电流"), I_3XBPH("3相不平衡电流"), U_A("A相电压"), U_B(
			"B相电压"), U_C("C相电压"), U_AB("AB线电压"), U_BC("BC线电压"), U_CA("CA线电压"), GV_YG(
			"有功功率"), GV_WG("无功功率"), GV_SZ("视在功率"), GV_GLYS("功率因数"), GV_ZB("周波"), GV_YG_A(
			"A相有功功率"), GV_YG_B("B相有功功率"), GV_YG_C("C相有功功率"), GV_WG_A("A相无功功率"), GV_WG_B(
			"B相无功功率"), GV_WG_C("C相无功功率"), GV_SZ_A("A相视在功率"), GV_SZ_B("B相视在功率"), GV_SZ_C(
			"C相视在功率"), GV_GVYS_A("A相功率因数"), GV_GVYS_B("B相功率因数"), GV_GVYS_C(
			"C相功率因数"),

	/******* 电量数据 *************/
	DL_ZX_Z("正向有功总电能"), DL_ZX_J("正向有功尖时电能"), DL_ZX_F("正向有功峰时电能"), DL_ZX_P(
			"正向有功平时电能"), DL_ZX_G("正向有功谷时电能"), DL_FX_Z("反向有功总电能"), DL_FX_J(
			"反向有功尖时电能"), DL_FX_F("反向有功峰时电能"), DL_FX_P("反向有功平时电能"), DL_FX_G(
			"反向有功谷时电能"),

	/******** 谐波数据 **************/
	XB_IA("A相电流总谐波含量"), XB_IB("B相电流总谐波含量"), XB_IC("C相电流总谐波含量"), XB_UA(
			"A相电压总谐波含量"), XB_UB("B相电压总谐波含量"), XB_UC("C相电压总谐波含量"), XB_IA_ARRAY(
			"A相电流谐波数组"), XB_IB_ARRAY("B相电流谐波数组"), XB_IC_ARRAY("C相电流谐波数组"), XB_UA_ARRAY(
			"A相电压谐波数组"), XB_UB_ARRAY("B相电压谐波数组"), XB_UC_ARRAY("C相电压谐波数组"),
			
	/******** 计量车 **************/
	JLC_QL_SH("气量瞬时流量"), JLC_QL_LJ("气量累计流量"), JLC_YL_SH("油量瞬时流量"), JLC_YL_LJ(
			"油量累计流量"), JLC_SL_SH("水量瞬时流量"), JLC_SL_LJ("水量累计流量"), JLC_HSL_SH(
			"瞬时含水率"), JLC_WD_SH("温度"), JLC_YALI_SH("压力"), JLC_MD_SH("密度"),
			
	/********* 注采 **************/
	ZC_ZQLL_SH("蒸汽流量瞬时值"), ZC_ZQLL_LJ("蒸汽流量累计值"), ZC_ZQYL("蒸汽压力"), ZC_ZQWD(
			"蒸汽温度"), ZC_ZQGD("蒸汽干度"), 
	
	/************RTU通讯状态*****************/
	RTU_RJ45_STATUS("以太网通讯状态"),RTU_COM1_STATUS("COM1通讯状态"),RTU_COM2_STATUS("COM2通讯状态"),RTU_COM3_STATUS("COM3通讯状态"),
	RTU_COM4_STATUS("COM4通讯状态"),RTU_ZIGBEE_STATUS("ZigBee通讯状态"),
	
	/****************传感器运行********************/
	CGQ_RTU_STATUS("传感器通讯状态"),CGQ_RTU_TIME("传感器运行时间"),CGQ_REMAINED_TIME("剩余工作时间"),CGQ_REMAINED_DIANLIANG("剩余电量"),
	
	/****************增压站遥测*************************/
	ZYZ_RU_KOU_WEN_DU("入口温度"),ZYZ_CHU_KOU_WEN_DU("出口温度"),ZYZ_WAI_SHU_YA_LI("外输压力"),ZYZ_HAN_SHUI_LV("原油含水率"),
	ZYZ_SHUN_SHI_LIU_LIANG("瞬时流量"),ZYZ_LEI_JI_LIU_LIANG("累积流量"),	ZYZ_YE_WEI("缓冲罐液位"),
	ZYZ_WEN_DU_1("环境温度#1"),ZYZ_WEN_DU_2("环境温度#2"),ZYZ_DIAN_DONG_DIE_FA("电动蝶阀值")
	;

	private String value;

	private VarSubTypeEnum(String value) {
		this.value = value;
	}

	private VarSubTypeEnum() {
		this(null);
	}

	public String getValue() {
		return value;
	}

	/**
	 * 通过中文名获得子类型名
	 * 
	 * @param value
	 * @return
	 */
	public static VarSubTypeEnum getByValue(String value) {
		for (VarSubTypeEnum type : VarSubTypeEnum.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}

}
