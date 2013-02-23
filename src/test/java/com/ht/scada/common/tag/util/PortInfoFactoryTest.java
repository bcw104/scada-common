package com.ht.scada.common.tag.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.exception.PortInfoErrorException;
import com.ht.scada.common.tag.util.PortInfoFactory.DtuInfo;
import com.ht.scada.common.tag.util.PortInfoFactory.TcpIpInfo;

public class PortInfoFactoryTest {
	
  @Test(dataProvider = "dtuErrorInfo")
  public void dtuInfoProvider(String s) {
  }

  @DataProvider
  public Object[][] dtuErrorInfo() {
    return new Object[][] {
      new Object[] { "dtu|" },
      new Object[] { "dtu|2000" },
      new Object[] { "dtu|:" },
      new Object[] { "dtu|:::" },
      new Object[] { "nop|2000:9815:hello:180" },
    };
  }
  
  @Test(dataProvider = "tcpErrorInfo")
  public void tcpInfoProvider(String s) {
  }

  @DataProvider
  public Object[][] tcpErrorInfo() {
    return new Object[][] {
      new Object[] { "tcp/ip|" },
      new Object[] { "tcp/ip|:" },
      new Object[] { "nop|192.168.1.110:4660" },
    };
  }

  @Test
  public void parseDtuInfo1() throws PortInfoErrorException {
	  DtuInfo dtuInfo = PortInfoFactory.parseDtuInfo("dtu|2000:9815:hello:180");
	  assert dtuInfo != null;
	  assert dtuInfo.dtuId.equals("2000");
	  assert dtuInfo.port == 9815;
	  assert dtuInfo.heartBeat.equals("hello");
	  assert dtuInfo.heartBeatInterval == 180;
			  
  }
  
  @Test(dataProvider="dtuErrorInfo", expectedExceptions=PortInfoErrorException.class)
  public void parseDtuInfo2(String portInfo) throws PortInfoErrorException {
	  PortInfoFactory.parseDtuInfo(portInfo);
  }

  @Test
  public void parseTcpIpInfo() throws PortInfoErrorException {
	  TcpIpInfo tcpIpInfo = PortInfoFactory.parseTcpIpInfo("tcp/ip|192.168.1.110:4660");
	  assert tcpIpInfo != null;
	  assert tcpIpInfo.ip.equals("192.168.1.110");
	  assert tcpIpInfo.port == 4660;
  }
  
  @Test(dataProvider="tcpErrorInfo", expectedExceptions=PortInfoErrorException.class)
  public void parseTcpInfo2(String portInfo) throws PortInfoErrorException {
	  PortInfoFactory.parseTcpIpInfo(portInfo);
  }
}
