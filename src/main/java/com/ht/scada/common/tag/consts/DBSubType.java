package com.ht.scada.common.tag.consts;

/**
 * 电表子类型
 * @author 薄成文
 *
 */
public interface DBSubType {
	public static final String YM_ZYZ = "正向有功总电能";
	public static final String YM_ZYJ = "正向有功尖电能";
	public static final String YM_ZYF = "正向有功峰电能";
	public static final String YM_ZYP = "正向有功平电能";
	public static final String YM_ZYG = "正向有功谷电能";
	
	public static final String YC_IA = "A相电流";
	public static final String YC_IB = "B相电流";
	public static final String YC_IC = "C相电流";
	
	public static final String YC_UA = "A相电压";
	public static final String YC_UB = "B相电压";
	public static final String YC_UC = "C相电压";
	
	public static final String YC_PFA = "A相功率因数";
	public static final String YC_PFB = "B相功率因数";
	public static final String YC_PFC = "C相功率因数";
	public static final String YC_PFZ = "总功率因数";
	
	public static final String YC_PYA = "A相有功功率";
	public static final String YC_PYB = "B相有功功率";
	public static final String YC_PYC = "C相有功功率";
	public static final String YC_PYZ = "总有功功率";
	
	public static final String YC_PWA = "A相无功功率";
	public static final String YC_PWB = "B相无功功率";
	public static final String YC_PWC = "C相无功功率";
	public static final String YC_PWZ = "总无功功率";
}
