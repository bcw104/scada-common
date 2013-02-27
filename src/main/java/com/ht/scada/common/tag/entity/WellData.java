package com.ht.scada.common.tag.entity;

import java.util.Date;



/**
 * 油井数据，包括示功图数据、最大载荷、最小载荷、冲程时间、冲次、冲程、光杆功率等
 * 
 * @author 赵磊
 * 
 */
public class WellData {
	
	/**
	 * 井号，可以是中文或英文，如草13-113、C13-P32
	 */
	private String wellNum;
	/**
	 * 载荷，示功图纵坐标
	 */
	private float[] zaihe;
	/**
	 * 位移，示功图横坐标
	 */
	private float[] weiyi;
	/**
	 * 冲程时间
	 */
	private float chongChengTime;
	/**
	 * 冲次
	 */
	private float chongCi;
	/**
	 * 冲程
	 */
	private float chongCheng;
	/**
	 * 最小载荷
	 */
	private float maxZaihe;
	/**
	 * 最大载荷
	 */
	private float minZaihe;
	
	
	public String getWellNum() {
		return wellNum;
	}
	public void setWellNum(String wellNum) {
		this.wellNum = wellNum;
	}
	public float[] getZaihe() {
		return zaihe;
	}
	public void setZaihe(float[] zaihe) {
		this.zaihe = zaihe;
	}
	public float[] getWeiyi() {
		return weiyi;
	}
	public void setWeiyi(float[] weiyi) {
		this.weiyi = weiyi;
	}
	public float getChongChengTime() {
		return chongChengTime;
	}
	public void setChongChengTime(float chongChengTime) {
		this.chongChengTime = chongChengTime;
	}
	public float getChongCi() {
		return chongCi;
	}
	public void setChongCi(float chongCi) {
		this.chongCi = chongCi;
	}
	public float getChongCheng() {
		return chongCheng;
	}
	public void setChongCheng(float chongCheng) {
		this.chongCheng = chongCheng;
	}
	public float getMaxZaihe() {
		return maxZaihe;
	}
	public void setMaxZaihe(float maxZaihe) {
		this.maxZaihe = maxZaihe;
	}
	public float getMinZaihe() {
		return minZaihe;
	}
	public void setMinZaihe(float minZaihe) {
		this.minZaihe = minZaihe;
	}
	
	
	

}