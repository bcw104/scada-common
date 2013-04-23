package com.ht.scada.common.tag.well.consts;

import java.util.ArrayList;
import java.util.List;

import com.ht.scada.common.tag.util.VarGroup;

/**
 * 变量key
 * @author 赵磊
 *
 */
public enum VarNameType {
	/*********油井*************/
	YOU_YA("油压",VarGroup.YOU_JING),TAO_YA("套压",VarGroup.YOU_JING), HUI_YA("回压", VarGroup.YOU_JING),JING_KOU_WEN_DU("井口温度", VarGroup.YOU_JING),HUI_GUAN_WEN_DU("汇管温度", VarGroup.YOU_JING),
	
	/*********示功图**************/
	CHONG_CHENG("冲程",VarGroup.YOU_JING_SGT),CHONG_CI("冲次",VarGroup.YOU_JING_SGT),SHANG_XING_CHONG_CI("上行冲次",VarGroup.YOU_JING_SGT),XIA_XING_CHONG_CI("下行冲次",VarGroup.YOU_JING_SGT),ZUI_DA_ZAI_HE("最大载荷",VarGroup.YOU_JING_SGT),ZUI_XIAO_ZAI_HE("最小载荷",VarGroup.YOU_JING_SGT),WEI_YI_ARRAY("位移数组",VarGroup.YOU_JING_SGT),ZAI_HE_ARRAY("载荷数组",VarGroup.YOU_JING_SGT),
	/********电功图****************/
	DIAN_LIU_ARRAY("电流数组",VarGroup.YOU_JING_DGT),GONG_LV_ARRAY("功率数组",VarGroup.YOU_JING_DGT),GONG_LV_YIN_SHU_ARRAY("功率因数数组",VarGroup.YOU_JING_DGT),DIAN_GONG_TU_ARRAY("电功图数组",VarGroup.YOU_JING_DGT),
	/********电力数据*************/
	I_A("A相电流",VarGroup.DIAN_YC),I_B("B相电流",VarGroup.DIAN_YC),I_C("C相电流",VarGroup.DIAN_YC),I_3XBPH("3相不平衡电流",VarGroup.DIAN_YC),U_A("A相电压",VarGroup.DIAN_YC),U_B("B相电压",VarGroup.DIAN_YC),U_C("C相电压",VarGroup.DIAN_YC),U_AB("AB线电压",VarGroup.DIAN_YC),U_BC("BC线电压",VarGroup.DIAN_YC),U_CA("CA线电压",VarGroup.DIAN_YC),GV_YG("有功功率",VarGroup.DIAN_YC),GV_WG("无功功率",VarGroup.DIAN_YC),GV_SZ("视在功率",VarGroup.DIAN_YC),GV_GLYS("功率因数",VarGroup.DIAN_YC),GV_ZB("周波",VarGroup.DIAN_YC),GV_YG_A("A相有功功率",VarGroup.DIAN_YC),GV_YG_B("B相有功功率",VarGroup.DIAN_YC),GV_YG_C("C相有功功率",VarGroup.DIAN_YC),GV_WG_A("A相无功功率",VarGroup.DIAN_YC),GV_WG_B("B相无功功率",VarGroup.DIAN_YC),GV_WG_C("C相无功功率",VarGroup.DIAN_YC),GV_SZ_A("A相视在功率",VarGroup.DIAN_YC),GV_SZ_B("B相视在功率",VarGroup.DIAN_YC),GV_SZ_C("C相视在功率",VarGroup.DIAN_YC),GV_GVYS_A("A相功率因数",VarGroup.DIAN_YC),GV_GVYS_B("B相功率因数",VarGroup.DIAN_YC),GV_GVYS_C("C相功率因数",VarGroup.DIAN_YC),
	
	/*******电量数据*************/
	DL_ZX_Z("正向有功总电能",VarGroup.DIAN_YM),DL_ZX_J("正向有功尖时电能",VarGroup.DIAN_YM),DL_ZX_F("正向有功峰时电能",VarGroup.DIAN_YM),DL_ZX_P("正向有功平时电能",VarGroup.DIAN_YM),DL_ZX_G("正向有功谷时电能",VarGroup.DIAN_YM),DL_FX_Z("反向有功总电能",VarGroup.DIAN_YM),DL_FX_J("反向有功尖时电能",VarGroup.DIAN_YM),DL_FX_F("反向有功峰时电能",VarGroup.DIAN_YM),DL_FX_P("反向有功平时电能",VarGroup.DIAN_YM),DL_FX_G("反向有功谷时电能",VarGroup.DIAN_YM),

	/********谐波数据**************/
	XB_I_A("A相电流总谐波含量",VarGroup.DIAN_XB),XB_I_B("B相电流总谐波含量",VarGroup.DIAN_XB),XB_I_C("C相电流总谐波含量",VarGroup.DIAN_XB),XB_U_A("A相电压总谐波含量",VarGroup.DIAN_XB),XB_U_B("B相电压总谐波含量",VarGroup.DIAN_XB),XB_U_C("C相电压总谐波含量",VarGroup.DIAN_XB),
	XB_I_A0("A相电流0次谐波",VarGroup.DIAN_XB),XB_I_A1("A相电流1次谐波",VarGroup.DIAN_XB),XB_I_A2("A相电流2次谐波",VarGroup.DIAN_XB),XB_I_A3("A相电流3次谐波",VarGroup.DIAN_XB),XB_I_A4("A相电流4次谐波",VarGroup.DIAN_XB),XB_I_A5("A相电流5次谐波",VarGroup.DIAN_XB),XB_I_A6("A相电流6次谐波",VarGroup.DIAN_XB),XB_I_A7("A相电流7次谐波",VarGroup.DIAN_XB),XB_I_A8("A相电流8次谐波",VarGroup.DIAN_XB),XB_I_A9("A相电流9次谐波",VarGroup.DIAN_XB),XB_I_A10("A相电流10次谐波",VarGroup.DIAN_XB),XB_I_A11("A相电流11次谐波",VarGroup.DIAN_XB),XB_I_A12("A相电流12次谐波",VarGroup.DIAN_XB),XB_I_A13("A相电流13次谐波",VarGroup.DIAN_XB),XB_I_A14("A相电流14次谐波",VarGroup.DIAN_XB),XB_I_A15("A相电流15次谐波",VarGroup.DIAN_XB),XB_I_A16("A相电流16次谐波",VarGroup.DIAN_XB),
	XB_I_A17("A相电流17次谐波",VarGroup.DIAN_XB),XB_I_A18("A相电流18次谐波",VarGroup.DIAN_XB),XB_I_A19("A相电流19次谐波",VarGroup.DIAN_XB),XB_I_A20("A相电流20次谐波",VarGroup.DIAN_XB),XB_I_A21("A相电流21次谐波",VarGroup.DIAN_XB),XB_I_A22("A相电流22次谐波",VarGroup.DIAN_XB),XB_I_A23("A相电流23次谐波",VarGroup.DIAN_XB),XB_I_A24("A相电流24次谐波",VarGroup.DIAN_XB),XB_I_A25("A相电流25次谐波",VarGroup.DIAN_XB),XB_I_A26("A相电流26次谐波",VarGroup.DIAN_XB),XB_I_A27("A相电流27次谐波",VarGroup.DIAN_XB),XB_I_A28("A相电流28次谐波",VarGroup.DIAN_XB),XB_I_A29("A相电流29次谐波",VarGroup.DIAN_XB),XB_I_A30("A相电流30次谐波",VarGroup.DIAN_XB),XB_I_A31("A相电流31次谐波",VarGroup.DIAN_XB),
	
	XB_I_B0("B相电流0次谐波",VarGroup.DIAN_XB),XB_I_B1("B相电流1次谐波",VarGroup.DIAN_XB),XB_I_B2("B相电流2次谐波",VarGroup.DIAN_XB),XB_I_B3("B相电流3次谐波",VarGroup.DIAN_XB),XB_I_B4("B相电流4次谐波",VarGroup.DIAN_XB),XB_I_B5("B相电流5次谐波",VarGroup.DIAN_XB),XB_I_B6("B相电流6次谐波",VarGroup.DIAN_XB),XB_I_B7("B相电流7次谐波",VarGroup.DIAN_XB),XB_I_B8("B相电流8次谐波",VarGroup.DIAN_XB),XB_I_B9("B相电流9次谐波",VarGroup.DIAN_XB),XB_I_B10("B相电流10次谐波",VarGroup.DIAN_XB),XB_I_B11("B相电流11次谐波",VarGroup.DIAN_XB),XB_I_B12("B相电流12次谐波",VarGroup.DIAN_XB),XB_I_B13("B相电流13次谐波",VarGroup.DIAN_XB),XB_I_B14("B相电流14次谐波",VarGroup.DIAN_XB),XB_I_B15("B相电流15次谐波",VarGroup.DIAN_XB),XB_I_B16("B相电流16次谐波",VarGroup.DIAN_XB),
	XB_I_B17("B相电流17次谐波",VarGroup.DIAN_XB),XB_I_B18("B相电流18次谐波",VarGroup.DIAN_XB),XB_I_B19("B相电流19次谐波",VarGroup.DIAN_XB),XB_I_B20("B相电流20次谐波",VarGroup.DIAN_XB),XB_I_B21("B相电流21次谐波",VarGroup.DIAN_XB),XB_I_B22("B相电流22次谐波",VarGroup.DIAN_XB),XB_I_B23("B相电流23次谐波",VarGroup.DIAN_XB),XB_I_B24("B相电流24次谐波",VarGroup.DIAN_XB),XB_I_B25("B相电流25次谐波",VarGroup.DIAN_XB),XB_I_B26("B相电流26次谐波",VarGroup.DIAN_XB),XB_I_B27("B相电流27次谐波",VarGroup.DIAN_XB),XB_I_B28("B相电流28次谐波",VarGroup.DIAN_XB),XB_I_B29("B相电流29次谐波",VarGroup.DIAN_XB),XB_I_B30("B相电流30次谐波",VarGroup.DIAN_XB),XB_I_B31("B相电流31次谐波",VarGroup.DIAN_XB),
	
	XB_I_C0("C相电流0次谐波",VarGroup.DIAN_XB),XB_I_C1("C相电流1次谐波",VarGroup.DIAN_XB),XB_I_C2("C相电流2次谐波",VarGroup.DIAN_XB),XB_I_C3("C相电流3次谐波",VarGroup.DIAN_XB),XB_I_C4("C相电流4次谐波",VarGroup.DIAN_XB),XB_I_C5("C相电流5次谐波",VarGroup.DIAN_XB),XB_I_C6("C相电流6次谐波",VarGroup.DIAN_XB),XB_I_C7("C相电流7次谐波",VarGroup.DIAN_XB),XB_I_C8("C相电流8次谐波",VarGroup.DIAN_XB),XB_I_C9("C相电流9次谐波",VarGroup.DIAN_XB),XB_I_C10("C相电流10次谐波",VarGroup.DIAN_XB),XB_I_C11("C相电流11次谐波",VarGroup.DIAN_XB),XB_I_C12("C相电流12次谐波",VarGroup.DIAN_XB),XB_I_C13("C相电流13次谐波",VarGroup.DIAN_XB),XB_I_C14("C相电流14次谐波",VarGroup.DIAN_XB),XB_I_C15("C相电流15次谐波",VarGroup.DIAN_XB),XB_I_C16("C相电流16次谐波",VarGroup.DIAN_XB),
	XB_I_C17("C相电流17次谐波",VarGroup.DIAN_XB),XB_I_C18("C相电流18次谐波",VarGroup.DIAN_XB),XB_I_C19("C相电流19次谐波",VarGroup.DIAN_XB),XB_I_C20("C相电流20次谐波",VarGroup.DIAN_XB),XB_I_C21("C相电流21次谐波",VarGroup.DIAN_XB),XB_I_C22("C相电流22次谐波",VarGroup.DIAN_XB),XB_I_C23("C相电流23次谐波",VarGroup.DIAN_XB),XB_I_C24("C相电流24次谐波",VarGroup.DIAN_XB),XB_I_C25("C相电流25次谐波",VarGroup.DIAN_XB),XB_I_C26("C相电流26次谐波",VarGroup.DIAN_XB),XB_I_C27("C相电流27次谐波",VarGroup.DIAN_XB),XB_I_C28("C相电流28次谐波",VarGroup.DIAN_XB),XB_I_C29("C相电流29次谐波",VarGroup.DIAN_XB),XB_I_C30("C相电流30次谐波",VarGroup.DIAN_XB),XB_I_C31("C相电流31次谐波",VarGroup.DIAN_XB),
	
	XB_U_A0("A相电压0次谐波",VarGroup.DIAN_XB),XB_U_A1("A相电压1次谐波",VarGroup.DIAN_XB),XB_U_A2("A相电压2次谐波",VarGroup.DIAN_XB),XB_U_A3("A相电压3次谐波",VarGroup.DIAN_XB),XB_U_A4("A相电压4次谐波",VarGroup.DIAN_XB),XB_U_A5("A相电压5次谐波",VarGroup.DIAN_XB),XB_U_A6("A相电压6次谐波",VarGroup.DIAN_XB),XB_U_A7("A相电压7次谐波",VarGroup.DIAN_XB),XB_U_A8("A相电压8次谐波",VarGroup.DIAN_XB),XB_U_A9("A相电压9次谐波",VarGroup.DIAN_XB),XB_U_A10("A相电压10次谐波",VarGroup.DIAN_XB),XB_U_A11("A相电压11次谐波",VarGroup.DIAN_XB),XB_U_A12("A相电压12次谐波",VarGroup.DIAN_XB),XB_U_A13("A相电压13次谐波",VarGroup.DIAN_XB),XB_U_A14("A相电压14次谐波",VarGroup.DIAN_XB),XB_U_A15("A相电压15次谐波",VarGroup.DIAN_XB),XB_U_A16("A相电压16次谐波",VarGroup.DIAN_XB),
	XB_U_A17("A相电压17次谐波",VarGroup.DIAN_XB),XB_U_A18("A相电压18次谐波",VarGroup.DIAN_XB),XB_U_A19("A相电压19次谐波",VarGroup.DIAN_XB),XB_U_A20("A相电压20次谐波",VarGroup.DIAN_XB),XB_U_A21("A相电压21次谐波",VarGroup.DIAN_XB),XB_U_A22("A相电压22次谐波",VarGroup.DIAN_XB),XB_U_A23("A相电压23次谐波",VarGroup.DIAN_XB),XB_U_A24("A相电压24次谐波",VarGroup.DIAN_XB),XB_U_A25("A相电压25次谐波",VarGroup.DIAN_XB),XB_U_A26("A相电压26次谐波",VarGroup.DIAN_XB),XB_U_A27("A相电压27次谐波",VarGroup.DIAN_XB),XB_U_A28("A相电压28次谐波",VarGroup.DIAN_XB),XB_U_A29("A相电压29次谐波",VarGroup.DIAN_XB),XB_U_A30("A相电压30次谐波",VarGroup.DIAN_XB),XB_U_A31("A相电压31次谐波",VarGroup.DIAN_XB),
	
	XB_U_B0("B相电压0次谐波",VarGroup.DIAN_XB),XB_U_B1("B相电压1次谐波",VarGroup.DIAN_XB),XB_U_B2("B相电压2次谐波",VarGroup.DIAN_XB),XB_U_B3("B相电压3次谐波",VarGroup.DIAN_XB),XB_U_B4("B相电压4次谐波",VarGroup.DIAN_XB),XB_U_B5("B相电压5次谐波",VarGroup.DIAN_XB),XB_U_B6("B相电压6次谐波",VarGroup.DIAN_XB),XB_U_B7("B相电压7次谐波",VarGroup.DIAN_XB),XB_U_B8("B相电压8次谐波",VarGroup.DIAN_XB),XB_U_B9("B相电压9次谐波",VarGroup.DIAN_XB),XB_U_B10("B相电压10次谐波",VarGroup.DIAN_XB),XB_U_B11("B相电压11次谐波",VarGroup.DIAN_XB),XB_U_B12("B相电压12次谐波",VarGroup.DIAN_XB),XB_U_B13("B相电压13次谐波",VarGroup.DIAN_XB),XB_U_B14("B相电压14次谐波",VarGroup.DIAN_XB),XB_U_B15("B相电压15次谐波",VarGroup.DIAN_XB),XB_U_B16("B相电压16次谐波",VarGroup.DIAN_XB),
	XB_U_B17("B相电压17次谐波",VarGroup.DIAN_XB),XB_U_B18("B相电压18次谐波",VarGroup.DIAN_XB),XB_U_B19("B相电压19次谐波",VarGroup.DIAN_XB),XB_U_B20("B相电压20次谐波",VarGroup.DIAN_XB),XB_U_B21("B相电压21次谐波",VarGroup.DIAN_XB),XB_U_B22("B相电压22次谐波",VarGroup.DIAN_XB),XB_U_B23("B相电压23次谐波",VarGroup.DIAN_XB),XB_U_B24("B相电压24次谐波",VarGroup.DIAN_XB),XB_U_B25("B相电压25次谐波",VarGroup.DIAN_XB),XB_U_B26("B相电压26次谐波",VarGroup.DIAN_XB),XB_U_B27("B相电压27次谐波",VarGroup.DIAN_XB),XB_U_B28("B相电压28次谐波",VarGroup.DIAN_XB),XB_U_B29("B相电压29次谐波",VarGroup.DIAN_XB),XB_U_B30("B相电压30次谐波",VarGroup.DIAN_XB),XB_U_B31("B相电压31次谐波",VarGroup.DIAN_XB),
	
	XB_U_C0("C相电压0次谐波",VarGroup.DIAN_XB),XB_U_C1("C相电压1次谐波",VarGroup.DIAN_XB),XB_U_C2("C相电压2次谐波",VarGroup.DIAN_XB),XB_U_C3("C相电压3次谐波",VarGroup.DIAN_XB),XB_U_C4("C相电压4次谐波",VarGroup.DIAN_XB),XB_U_C5("C相电压5次谐波",VarGroup.DIAN_XB),XB_U_C6("C相电压6次谐波",VarGroup.DIAN_XB),XB_U_C7("C相电压7次谐波",VarGroup.DIAN_XB),XB_U_C8("C相电压8次谐波",VarGroup.DIAN_XB),XB_U_C9("C相电压9次谐波",VarGroup.DIAN_XB),XB_U_C10("C相电压10次谐波",VarGroup.DIAN_XB),XB_U_C11("C相电压11次谐波",VarGroup.DIAN_XB),XB_U_C12("C相电压12次谐波",VarGroup.DIAN_XB),XB_U_C13("C相电压13次谐波",VarGroup.DIAN_XB),XB_U_C14("C相电压14次谐波",VarGroup.DIAN_XB),XB_U_C15("C相电压15次谐波",VarGroup.DIAN_XB),XB_U_C16("C相电压16次谐波",VarGroup.DIAN_XB),
	XB_U_C17("C相电压17次谐波",VarGroup.DIAN_XB),XB_U_C18("C相电压18次谐波",VarGroup.DIAN_XB),XB_U_C19("C相电压19次谐波",VarGroup.DIAN_XB),XB_U_C20("C相电压20次谐波",VarGroup.DIAN_XB),XB_U_C21("C相电压21次谐波",VarGroup.DIAN_XB),XB_U_C22("C相电压22次谐波",VarGroup.DIAN_XB),XB_U_C23("C相电压23次谐波",VarGroup.DIAN_XB),XB_U_C24("C相电压24次谐波",VarGroup.DIAN_XB),XB_U_C25("C相电压25次谐波",VarGroup.DIAN_XB),XB_U_C26("C相电压26次谐波",VarGroup.DIAN_XB),XB_U_C27("C相电压27次谐波",VarGroup.DIAN_XB),XB_U_C28("C相电压28次谐波",VarGroup.DIAN_XB),XB_U_C29("C相电压29次谐波",VarGroup.DIAN_XB),XB_U_C30("C相电压30次谐波",VarGroup.DIAN_XB),XB_U_C31("C相电压31次谐波",VarGroup.DIAN_XB),
	
	/********计量车**************/
	JLC_QL_SH("气量瞬时流量",VarGroup.JI_LIANG),JLC_QL_LJ("气量累计流量",VarGroup.JI_LIANG),JLC_YL_SH("油量瞬时流量",VarGroup.JI_LIANG),JLC_YL_LJ("油量累计流量",VarGroup.JI_LIANG),JLC_SL_SH("水量瞬时流量",VarGroup.JI_LIANG),JLC_SL_LJ("水量累计流量",VarGroup.JI_LIANG),
	JLC_HSL_SH("瞬时含水率",VarGroup.JI_LIANG),JLC_WD_SH("温度",VarGroup.JI_LIANG),JLC_YALI_SH("压力",VarGroup.JI_LIANG),JLC_MD_SH("密度",VarGroup.JI_LIANG),
	/*********注采**************/
	ZC_ZQLL_SH("蒸汽流量瞬时值",VarGroup.ZHU_CAI),ZC_ZQLL_LJ("蒸汽流量累计值",VarGroup.ZHU_CAI),ZC_ZQYL("蒸汽压力",VarGroup.ZHU_CAI),ZC_ZQWD("蒸汽温度",VarGroup.ZHU_CAI),ZC_ZQGD("蒸汽干度",VarGroup.ZHU_CAI),
	;
	
	private String value;
	private VarGroup varGroup;
	
	private VarNameType(String value) {
		this.value = value;
	}
	private VarNameType(String value, VarGroup varGroup) {
		this.value = value;
		this.varGroup = varGroup;
	}
	private VarNameType() {
		this(null);
	}
	public String getValue() {
		return value;
	}
	
	public VarGroup getVarGroup() {
		return varGroup;
	}
	/**
	 * 通过中文名获得变量名
	 * @param value
	 * @return
	 */
	public static VarNameType getByValue(String value) {
		for(VarNameType type : VarNameType.values()) {
			if(type.getValue().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
	/**
	 * 通过变量分组获得变量列表
	 * @param value
	 * @return
	 */
	public static List<VarNameType> getVarNamesByGroup(String value) {
		List<VarNameType> varNameList = new ArrayList<VarNameType>();
		for(VarNameType type : VarNameType.values()) {
			if(type.getValue().equals(value)) {
				varNameList.add(type);
			}
		}
		return varNameList;
	}
	
	/**
	 * 通过变量分组获得变量列表
	 * @param value
	 * @return
	 */
	public static List<String> getVarNamesArrayByGroup(String value) {
		List<String> varNameList = new ArrayList<String>();
		for(VarNameType type : VarNameType.values()) {
			if(type.getValue().equals(value)) {
				varNameList.add(type.getValue());
			}
		}
		return varNameList;
	}
	
	public static void main(String args[]) {
		System.out.println(VarNameType.values().length);
	}

}
