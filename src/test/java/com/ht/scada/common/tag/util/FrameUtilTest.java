package com.ht.scada.common.tag.util;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.exception.FrameInfoErrorException;

public class FrameUtilTest {
	
  @Test(dataProvider = "modbusErrorFrame")
  public void modbusFrmaeProvider(String s) {
  }

  @DataProvider
  public Object[][] modbusErrorFrame() {
    return new Object[][] {
      new Object[] { "1|3-1|3|" },
      new Object[] { "1|3-100-10|a|soe" },
      new Object[] { "1|3-100-10-3|0" },
      new Object[] { "1|3-1a0-10|0|soe" },
      new Object[] { "a|3-10-10|0|soe" },
      new Object[] { "1||0|soe" },
      new Object[] { "1|3-1-10|3|,a" },
    };
  }

  @Test(dataProvider="modbusErrorFrame", expectedExceptions=FrameInfoErrorException.class)
  public void parseModbusFramesError(String frames) throws FrameInfoErrorException {
	  FrameUtil.parseModbusFrames(frames);
  }

  @Test
  public void parseModbusFrames() throws FrameInfoErrorException {
	  List<ModbusFrame> list = FrameUtil.parseModbusFrames("1|3-1-10|3|");
	  assert list != null && !list.isEmpty() : "返回结果为空";
	  assert list.size() == 1 : "期望的返回结果集为1，实际返回的结果集为"+list.size();
	  ModbusFrame frame = list.get(0);
	  assert frame.getSlave()[0][0] == 1;
	  assert frame.getFunCode() == 3;
	  assert frame.getStart() == 1;
	  assert frame.getLen() == 10;
	  assert frame.getPriority() == 3;
	  assert frame.getName() == null;
	  
	  list = FrameUtil.parseModbusFrames("1|3-100-10|0|soe");
	  frame = list.get(0);
	  assert frame.getName() != null;
	  
	  list = FrameUtil.parseModbusFrames("1-10 13-23|3-1-10|3|");
	  frame = list.get(0);
	  assert frame.getSlave().length == 2;
	  assert frame.getSlave()[0][0] == 1;
	  assert frame.getSlave()[0][1] == 10;
	  assert frame.getSlave()[1][0] == 13;
	  assert frame.getSlave()[1][1] == 23;
	  assert frame.getName() == null;
	  
	  list = FrameUtil.parseModbusFrames("1-10 13-23|3-1-10|3|,1|3-100-10|0|soe");
	  assert list != null && !list.isEmpty() : "返回结果为空";
	  assert list.size() == 2 : "期望的返回结果集为2，实际返回的结果集为"+list.size();
	  frame = list.get(0);
	  assert frame.getSlave().length == 2;
	  assert frame.getName() == null;
	  frame = list.get(1);
	  assert frame.getSlave().length == 1;
	  assert frame.getName() != null;
  }
}
