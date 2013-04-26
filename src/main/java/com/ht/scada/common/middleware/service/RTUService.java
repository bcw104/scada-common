package com.ht.scada.common.middleware.service;

/**
 * 实现对RTU的遥控遥调操作
 * @author 薄成文
 *
 */
public interface RTUService {
	
	/**
	 * 遥控、遥调操作消息应答中的boolean属性名称：<br>
	 * replyMessage.setBooleanProperty("success", true);<br>
	 * sucess=true表示操作成功
	 */
	public static final String OP_REPLY_KEY = "success";
	
	/**
	 * 当前操作的有效时间，如果消息失效，则放弃操作
	 */
	public static final String TIME_MILLIS = "timeMillis";
	
	/**
	 * 遥控操作
	 * @param code 末端编码
	 * @param varName 变量名称
	 * @param status 操作值，true:合,false:分
	 * @return true表示操作成功
	 * @throws Exception 
	 */
	boolean yk(String code, String varName, boolean status) throws Exception;
	
	/**
	 * @param code
	 * @param varName
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	boolean yt(String code, String varName, double value) throws Exception;
}
