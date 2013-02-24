package com.ht.scada.common.tag.util;

import java.util.ArrayList;
import java.util.List;

import com.ht.scada.common.tag.exception.StorageInfoErrorException;

/**
 * 存储器工厂：用于解析或生成变量模板中的存储器<br>
 * <pre>
 * 故障存储器：fault|1|合闸|分闸|true<br> 
 * 	【存储器类型】|【报警标志1/0】|【合消息】|【分消息】|【是否推画面】<br> </pre>
 * <pre>
 * 遥信变位存储器：yx|-1|合闸|分闸|true <br>
 * 	【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】<br> </pre>
 * <pre>
 * 越限存储器：offlimits|500|电流越过上限|true|true <br>
 * 	【存储器类型】|【限值】|【越限信息】|【越限类型（true:上限，false:下限）】|【是否推画面】<br> </pre>
 * <pre>
 * 遥测存储器：yc||10 <br>
 * 	【存储器类型】|【变化范围（可以为空）】|【周期(分钟)】<br> </pre>
 * <pre>
 * 遥脉存储器：ym|0|599999999|1|0 <br>
 * 	【存储器类型】|【最小值】|【最大值】|单位脉冲电度量|周期（可以为空）<br> </pre>
 * 
 * 注:越限存储器可以为多个，多个存储器需要用逗号隔开<br>
 * @author 薄成文
 **/
public class StorageFactory {
	
	public static final String FAULT_PREFIX = "fault";
	public static final String OFFLIMITS_PREFIX = "offlimits";
	public static final String YX_PREFIX = "yx";
	public static final String YC_PREFIX = "yc";
	public static final String YM_PREFIX = "ym";

	/*
	 * 持久化属性
	 * 
	 * 多个存储器用逗号隔开
	 * 
	 * 故障存储器： 		fault|1|合闸|分闸|true 
	 * 				【存储器类型】|【报警标志1/0】|【合消息】|【分消息】|【是否推画面】
	 * 遥信变位存储器： 	yx|-1|合闸|分闸|true 
	 * 				【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】
	 * 遥测越限存储器：	offlimits|500|电流越过上限|true|true 
	 * 				【存储器类型】|【限值】|【越限信息】|【越限类型（true:上限，false:下限）】|【是否推画面】
	 * 遥测存储器：		yc||10 
	 * 				【存储器类型】|【变化范围（可以为空）】|【周期(分钟)】
	 * 遥脉存储器：		ym|0|599999999|1|0 
	 * 				【存储器类型】|【最小值】|【最大值】|单位脉冲电度量|周期（可以为空）
	 **/
	
	public static Object parseStorage(String storage) throws StorageInfoErrorException {
		if (storage.startsWith(YX_PREFIX)) {
			return parseYXStorage(storage);
		} else if (storage.startsWith(YC_PREFIX)) {
			return parseYCStorage(storage);
		} else if (storage.startsWith(YM_PREFIX)) {
			return parseYMStorage(storage);
		} else if (storage.startsWith(FAULT_PREFIX)) {
			return parseFaultStorage(storage);
		} else if (storage.startsWith(OFFLIMITS_PREFIX)) {
			return parseOffLimitsStorages(storage);
		}
		return null;
	}
	
	public static FaultStorage parseFaultStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals(FAULT_PREFIX)) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			
			try {
				boolean flag = !storageInfoArray[1].equals("0");
				String onInfo = storageInfoArray[2];
				String offInfo = storageInfoArray[3];
				boolean pushWnd = Boolean.parseBoolean(storageInfoArray[4]);
				FaultStorage faultStorage = new FaultStorage(name, flag, onInfo, offInfo, pushWnd);
				return faultStorage;
			} catch (Exception e) {
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
	}
	
	public static YXStorage parseYXStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals(YX_PREFIX)) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			
			try {
				int alarmType = Integer.parseInt(storageInfoArray[1]);
				String onInfo = storageInfoArray[2];
				String offInfo = storageInfoArray[3];
				boolean pushWnd = Boolean.parseBoolean(storageInfoArray[4]);
				YXStorage rsChangeStorage = new YXStorage(name, alarmType, onInfo, offInfo, pushWnd);
				return rsChangeStorage;
			} catch (Exception e) {
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
	}
	
	public static List<OffLimitsStorage> parseOffLimitsStorages(String storages) throws StorageInfoErrorException {
		String[] storageInfoArray = storages.split(",");
		List<OffLimitsStorage> list = new ArrayList<>(storageInfoArray.length);
		for (String storage : storageInfoArray) {
			list.add(parseOffLimitsStorage(storage));
		}
		return list;
	}
	
	private static OffLimitsStorage parseOffLimitsStorage(String storage) throws StorageInfoErrorException {
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals(OFFLIMITS_PREFIX)) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			
			try {
				double threshold = Double.parseDouble(storageInfoArray[1]);
				String info = storageInfoArray[2];
				boolean type = Boolean.parseBoolean(storageInfoArray[3]);
				boolean pushWnd = Boolean.parseBoolean(storageInfoArray[4]);
				OffLimitsStorage thresholdStorage = new OffLimitsStorage(name, threshold, info, type, pushWnd);
				return thresholdStorage;
			} catch (Exception e) {
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
	}
	
	public static YCStorage parseYCStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 3 && storageInfoArray.length != 2) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals(YC_PREFIX)) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			try {
				double threshold = -1;
				if (!storageInfoArray[1].isEmpty()) {
					threshold = Double.parseDouble(storageInfoArray[1]);
				}
				int interval = -1;
				if (storageInfoArray.length == 3) {
					interval = Integer.parseInt(storageInfoArray[2]);
				}
				YCStorage ycStorage = new YCStorage(name, threshold, interval);
				return ycStorage;
			} catch (Exception e) {
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
		
	}
	
	public static YMStorage parseYMStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5 && storageInfoArray.length != 4) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			try {
				String name = storageInfoArray[0];
				if (!name.equals(YM_PREFIX)) {
					throw new StorageInfoErrorException("存储器格式错误："+storage);
				}
				double min = Double.parseDouble(storageInfoArray[1]);
				double max = Double.parseDouble(storageInfoArray[2]);
				int unit = Integer.parseInt(storageInfoArray[3]);
				int interval = -1;
				if (storageInfoArray.length == 5) {
					interval = Integer.parseInt(storageInfoArray[4]);
				}
				YMStorage ymStorage = new YMStorage(name, min, max, unit, interval);
				return ymStorage;
			} catch (Exception e) {
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
		
	}
	
	public static class YMStorage {
		
		public String name;
		public double min;		// 最小值
		public double max;		// 最大值
		public int unit;		// 单位脉冲电度量
		public int interval;	// 周期（分钟）
		
		private YMStorage(String name, double min, double max, int unit,
				int interval) {
			this.name = name;
			this.min = min;
			this.max = max;
			this.unit = unit;
			this.interval = interval;
		}
	}
	
	public static class YCStorage {
		public String name;
		public double threshold;	// 限值
		public int interval;		// 周期(分钟)
		private YCStorage(String name, double threshold, int interval) {
			this.name = name;
			this.threshold = threshold;
			this.interval = interval;
		}
	}
	
	/**
	 * 遥测越限报警
	 * @author 薄成文
	 *
	 */
	public static class OffLimitsStorage {
		
		public String name;
		public double threshold;	// 限值
		public String info;		// 越限信息
		
		/**
		 * 越限类型，true表示越上限，false表示越下限
		 */
		public boolean type;
		
		/**
		 * 推画面
		 */
		public boolean pushWnd;	
		
		private OffLimitsStorage(String name, double threshold, String info, boolean type,
				boolean pushWnd) {
			this.name = name;
			this.threshold = threshold;
			this.info = info;
			this.type = type;
			this.pushWnd = pushWnd;
		}
	}
	
	
	public static class YXStorage {
		public String name;
		public int alarmType;	// 报警类型
		public String onInfo;	// 合消息
		public String offInfo;	// 分消息
		public boolean pushWnd;// 推画面
		private YXStorage(String name, int alarmType, String onInfo, String offInfo,
				boolean pushWnd) {
			this.name = name;
			this.alarmType = alarmType;
			this.onInfo = onInfo;
			this.offInfo = offInfo;
			this.pushWnd = pushWnd;
		}
		
	}
	
	public static class FaultStorage {
		public String name;
		public boolean flag;	// 有效状态
		public String onInfo;	// 合消息
		public String offInfo;	// 分消息
		public boolean pushWnd;// 推画面
		
		private FaultStorage(String name, boolean flag, String onInfo, String offInfo,
				boolean pushWnd) {
			this.name = name;
			this.flag = flag;
			this.onInfo = onInfo;
			this.offInfo = offInfo;
			this.pushWnd = pushWnd;
		}
		
	}
	
}
