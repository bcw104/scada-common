package com.ht.scada.common.tag.util;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.exception.FrameInfoErrorException;
import com.ht.scada.common.tag.util.ChannelFrameFactory.ModbusFrame;

public class FrameFactoryTest {
	
	
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
	  ChannelFrameFactory.parseModbusFrames(frames);
  }

  @Test
  public void parseModbusFrames() throws FrameInfoErrorException {
	  List<ModbusFrame> list = ChannelFrameFactory.parseModbusFrames("1|3-1-10|3|");
	  assert list != null && !list.isEmpty() : "返回结果为空";
	  assert list.size() == 1 : "期望的返回结果集为1，实际返回的结果集为"+list.size();
	  ModbusFrame frame = list.get(0);
	  assert frame.slave[0][0] == 1;
	  assert frame.funCode == 3;
	  assert frame.start == 1;
	  assert frame.len == 10;
	  assert frame.priority == 3;
	  assert frame.name == null;
	  
	  list = ChannelFrameFactory.parseModbusFrames("1|3-100-10|0|soe");
	  frame = list.get(0);
	  assert frame.name != null;
	  
	  list = ChannelFrameFactory.parseModbusFrames("1-10 13-23|3-1-10|3|");
	  frame = list.get(0);
	  assert frame.slave.length == 2;
	  assert frame.slave[0][0] == 1;
	  assert frame.slave[0][1] == 10;
	  assert frame.slave[1][0] == 13;
	  assert frame.slave[1][1] == 23;
	  assert frame.name == null;
	  
	  list = ChannelFrameFactory.parseModbusFrames("1-10 13-23|3-1-10|3|,1|3-100-10|0|soe");
	  assert list != null && !list.isEmpty() : "返回结果为空";
	  assert list.size() == 2 : "期望的返回结果集为2，实际返回的结果集为"+list.size();
	  frame = list.get(0);
	  assert frame.slave.length == 2;
	  assert frame.name == null;
	  frame = list.get(1);
	  assert frame.slave.length == 1;
	  assert frame.name != null;
  }
}
