package com.ht.scada.common.tag.util;

import java.util.ArrayList;
import java.util.List;

import com.ht.scada.common.tag.exception.StorageInfoErrorException;

public class StorageFactory {

	/*
	 * 持久化属性
	 * 
	 * 多个存储器用逗号隔开
	 * 
	 * 故障存储器： 		fault|1|合闸|分闸|true 
	 * 				【存储器类型】|【报警标志1/0】|【合消息】|【分消息】|【是否推画面】
	 * 变位存储器： 		rschange|-1|合闸|分闸|true 
	 * 				【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】
	 * 遥测越限存储器：	threshold|500|电流越过上限|true|true 
	 * 				【存储器类型】|【限值】|【越限信息】|【越限类型（true:上限，false:下限）】|【是否推画面】
	 * 遥测存储器：		yc||10 
	 * 				【存储器类型】|【变化范围（可以为空）】|【周期(分钟)】
	 * 遥脉存储器：		ym|0|599999999|1|0 
	 * 				【存储器类型】|【最小值】|【最大值】|单位脉冲电度量|周期（可以为空）
	 **/
	
	public static FaultStorage parseFaultStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals("fault")) {
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
				e.printStackTrace();
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
	}
	
	public static RSChangeStorage parseRSChangeStorage(String storage) throws StorageInfoErrorException {
		
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals("rschange")) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			
			try {
				int alarmType = Integer.parseInt(storageInfoArray[1]);
				String onInfo = storageInfoArray[2];
				String offInfo = storageInfoArray[3];
				boolean pushWnd = Boolean.parseBoolean(storageInfoArray[4]);
				RSChangeStorage rsChangeStorage = new RSChangeStorage(name, alarmType, onInfo, offInfo, pushWnd);
				return rsChangeStorage;
			} catch (Exception e) {
				e.printStackTrace();
				throw new StorageInfoErrorException("存储器格式解析错误："+storage+","+e.getMessage());
			}
		}
	}
	
	public static List<ThresholdStorage> parseThresholdStorages(String storages) throws StorageInfoErrorException {
		String[] storageInfoArray = storages.split(",");
		List<ThresholdStorage> list = new ArrayList<>(storageInfoArray.length);
		for (String storage : storageInfoArray) {
			list.add(parseThresholdStorage(storage));
		}
		return list;
	}
	
	private static ThresholdStorage parseThresholdStorage(String storage) throws StorageInfoErrorException {
		String[] storageInfoArray = storage.split("\\|");
		if (storageInfoArray.length != 5) {
			throw new StorageInfoErrorException("存储器格式错误："+storage);
		} else {
			String name = storageInfoArray[0];
			if (!name.equals("threshold")) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			
			try {
				double threshold = Double.parseDouble(storageInfoArray[1]);
				String info = storageInfoArray[2];
				boolean type = Boolean.parseBoolean(storageInfoArray[3]);
				boolean pushWnd = Boolean.parseBoolean(storageInfoArray[4]);
				ThresholdStorage thresholdStorage = new ThresholdStorage(name, threshold, info, type, pushWnd);
				return thresholdStorage;
			} catch (Exception e) {
				e.printStackTrace();
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
			if (!name.equals("yc")) {
				throw new StorageInfoErrorException("存储器格式错误："+storage);
			}
			try {
				double threshold = Double.NaN;
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
				e.printStackTrace();
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
				if (!name.equals("ym")) {
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
				e.printStackTrace();
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
	public static class ThresholdStorage {
		
		public String name;
		public double threshold;	// 限值
		public String info;		// 越限信息
		public boolean type;		// 越限类型，true表示越上限，false表示越下限
		public boolean pushWnd;	// 推画面
		
		private ThresholdStorage(String name, double threshold, String info, boolean type,
				boolean pushWnd) {
			this.name = name;
			this.threshold = threshold;
			this.info = info;
			this.type = type;
			this.pushWnd = pushWnd;
		}
	}
	
	
	public static class RSChangeStorage {
		public String name;
		public int alarmType;	// 报警类型
		public String onInfo;	// 合消息
		public String offInfo;	// 分消息
		public boolean pushWnd;// 推画面
		private RSChangeStorage(String name, int alarmType, String onInfo, String offInfo,
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
