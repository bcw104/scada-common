package com.ht.scada.common.tag.util;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.exception.StorageInfoErrorException;
import com.ht.scada.common.tag.util.StorageFactory.FaultStorage;
import com.ht.scada.common.tag.util.StorageFactory.OffLimitsStorage;
import com.ht.scada.common.tag.util.StorageFactory.YXStorage;

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
  
  @Test(dataProvider = "offLimitsDp")
  public void offLimits(String s) {
  }

  @DataProvider
  public Object[][] offLimitsDp() {//【存储器类型】|【限值】|【越限信息】|【越限类型（true:上限，false:下限）】|【是否推画面】
    return new Object[][] {
      new Object[] { "nop|500|电流越过上限|true|true" },
      new Object[] { "offlimits|a500|电流越过上限|true|true" },
      new Object[] { "offlimits|500|电流越过上限|true|" },
    };
  }
  
  @Test(dataProvider = "yxDp")
  public void yxChange(String s) {
  }

  @DataProvider
  public Object[][] yxDp() {//【存储器类型】|【报警类型1/0/-1】|【合消息】|【分消息】|【是否推画面】
    return new Object[][] {
      new Object[] { "yx|-1.0|合闸|分闸|true" },
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
  public void parseYXStorage() throws StorageInfoErrorException {
    YXStorage storage = StorageFactory.parseYXStorage("yx|-1|合闸|分闸|true");
    assert storage.offInfo.equals("分闸");
    assert storage.onInfo.equals("合闸");
    assert storage.alarmType == -1;
    assert storage.pushWnd;
    
    storage = StorageFactory.parseYXStorage("yx|1|合闸|分闸|true");
    assert storage.alarmType == 1;
  }
  
  @Test(dataProvider="yxDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseRSChangeStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseYXStorage(storage);
  }

  @Test
  public void parseOffLimitsStorages() throws StorageInfoErrorException {
	  List<OffLimitsStorage> storageList = StorageFactory.parseOffLimitsStorages("offlimits|500|电流越过上限|true|true");
	  assert storageList != null;
	  assert storageList.size() == 1;
	  OffLimitsStorage storage = storageList.get(0);
	  assert storage.info.equals("电流越过上限");
	  assert storage.threshold == 500;
	  assert storage.type;
	  assert storage.pushWnd;
	  
	  storageList = StorageFactory.parseOffLimitsStorages("offlimits|500|电流越过上限|!true|!true");
	  assert storageList != null;
	  assert !storageList.isEmpty();
	  storage = storageList.get(0);
	  assert !storage.type;
	  assert !storage.pushWnd;
	  
	  storageList = StorageFactory.parseOffLimitsStorages("offlimits|500|电流越过上限|true|!true,offlimits|500|电流越过下限|true|!true");
	  assert storageList != null;
	  assert storageList.size() == 2;
  }
  
  @Test(dataProvider="offLimitsDp", expectedExceptions=StorageInfoErrorException.class)
  public void parseThresholdStorage2(String storage) throws StorageInfoErrorException {
    StorageFactory.parseOffLimitsStorages(storage);
  }

}
