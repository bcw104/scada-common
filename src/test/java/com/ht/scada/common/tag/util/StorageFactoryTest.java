package com.ht.scada.common.tag.util;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.exception.StorageInfoErrorException;
import com.ht.scada.common.tag.util.StorageFactory.FaultStorage;
import com.ht.scada.common.tag.util.StorageFactory.RSChangeStorage;
import com.ht.scada.common.tag.util.StorageFactory.ThresholdStorage;
import com.ht.scada.common.tag.util.StorageFactory.YCStorage;
import com.ht.scada.common.tag.util.StorageFactory.YMStorage;

public class StorageFactoryTest {
	
  @Test(dataProvider = "ymDp")
  public void ym(String s) {
  }

  @DataProvider
  public Object[][] ymDp() {//【存储器类型】|【最小值】|【最大值】|单位脉冲电度量|周期（可以为空）
    return new Object[][] {
      new Object[] { "yc|0|599999999|1|" },
      new Object[] { "ym|c|599999999|1|" },
      new Object[] { "ym|c|599999999|1 |" },
      new Object[] { "ym|c|599999999|1 |" },
    };
  }
  
  @Test(dataProvider = "ycDp")
  public void yc(String s) {
  }

  @DataProvider
  public Object[][] ycDp() {//【存储器类型】|【变化范围（可以为空）】|【周期(分钟)】
    return new Object[][] {
      new Object[] { "yc||" },
      new Object[] { "yc|n50|" },
      new Object[] { "ym|50|" },
      new Object[] { "yc|50|dd" },
    };
  }
  
  @Test(dataProvider = "thresholdDp")
  public void threshold(String s) {
  }

  @DataProvider
  public Object[][] thresholdDp() {//【存储器类型】|【限值】|【越限信息】|【越限类型（true:上限，false:下限）】|【是否推画面】
    return new Object[][] {
      new Object[] { "nop|500|电流越过上限|true|true" },
      new Object[] { "threshold|a500|电流越过上限|true|true" },
      new Object[] { "threshold|500|电流越过上限|true|" },
    };
  }
  
  @Test(dataProvider = "rsChangeDp")
  public void rsChange(String s) {
  }

  @DataProvider
  public Object[][] rsChangeDp() {//【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】
    return new Object[][] {
      new Object[] { "rschange|-1.0|合闸|分闸|true" },
      new Object[] { "nop|1|合闸|分闸|true" },
      new Object[] { "nop|1|合闸|分闸|0" },
      new Object[] { "nop|1|合闸|分闸|" },
    };
  }
  
  @Test(dataProvider = "faultDp")
  public void fault(String s) {
  }

  @DataProvider
  public Object[][] faultDp() {//【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】
    return new Object[][] {
      new Object[] { "nop|1|合闸|分闸|true" },
      new Object[] { "fault|1|合闸|分闸|" },
      new Object[] { "fault|1|合闸|分闸" },
    };
  }

  @Test
  public void parseFaultStorage() throws StorageInfoErrorException {
    FaultStorage storage = StorageFactory.parseFaultStorage("fault|1|合闸|分闸|true");
    assert storage.flag;
    assert storage.offInfo.equals("分闸");
    assert storage.onInfo.equals("合闸");
    assert storage.pushWnd;
  }
  
  @Test(dataProvider="faultDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseFaultStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseFaultStorage(storage);
  }

  @Test
  public void parseRSChangeStorage() throws StorageInfoErrorException {
    RSChangeStorage storage = StorageFactory.parseRSChangeStorage("rschange|-1|合闸|分闸|true");
    assert storage.offInfo.equals("分闸");
    assert storage.onInfo.equals("合闸");
    assert storage.alarmType == -1;
    assert storage.pushWnd;
    
    storage = StorageFactory.parseRSChangeStorage("rschange|1|合闸|分闸|true");
    assert storage.alarmType == 1;
  }
  
  @Test(dataProvider="rsChangeDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseRSChangeStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseRSChangeStorage(storage);
  }

  @Test
  public void parseThresholdStorages() throws StorageInfoErrorException {
	  List<ThresholdStorage> storageList = StorageFactory.parseThresholdStorages("threshold|500|电流越过上限|true|true");
	  assert storageList != null;
	  assert storageList.size() == 1;
	  ThresholdStorage storage = storageList.get(0);
	  assert storage.info.equals("电流越过上限");
	  assert storage.threshold == 500;
	  assert storage.type;
	  assert storage.pushWnd;
	  
	  storageList = StorageFactory.parseThresholdStorages("threshold|500|电流越过上限|!true|!true");
	  assert storageList != null;
	  assert !storageList.isEmpty();
	  storage = storageList.get(0);
	  assert !storage.type;
	  assert !storage.pushWnd;
	  
	  storageList = StorageFactory.parseThresholdStorages("threshold|500|电流越过上限|true|!true,threshold|500|电流越过下限|true|!true");
	  assert storageList != null;
	  assert storageList.size() == 2;
  }
  
  @Test(dataProvider="thresholdDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseThresholdStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseThresholdStorages(storage);
  }

  @Test
  public void parseYCStorage() throws StorageInfoErrorException {
    YCStorage ycStorage = StorageFactory.parseYCStorage("yc|50|10");
    assert ycStorage.interval == 10;
    assert ycStorage.threshold == 50;
    ycStorage = StorageFactory.parseYCStorage("yc||10");
    assert Double.isNaN(ycStorage.threshold);
    assert ycStorage.interval == 10;
    ycStorage = StorageFactory.parseYCStorage("yc|50|");
    assert ycStorage.threshold == 50;
    assert ycStorage.interval<0;
  }
  
  @Test(dataProvider="ycDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseYCStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseYCStorage(storage);
  }

  @Test
  public void parseYMStorage() throws StorageInfoErrorException {
    YMStorage storage = StorageFactory.parseYMStorage("ym|0|599999999|1|0");
    assert storage.max == 599999999;
    assert storage.min == 0;
    assert storage.unit == 1;
    assert storage.interval == 0;
    
    storage = StorageFactory.parseYMStorage("ym|0|599999999|1|");
    assert storage.interval == -1;
    storage = StorageFactory.parseYMStorage("ym|0|599999999|1");
    assert storage.interval == -1;
  }
  
  @Test(dataProvider="ymDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseYMStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseYMStorage(storage);
  }
}
