package com.ht.scada.common.data.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

import com.ht.scada.common.data.service.BaseDataService;

public class BaseDataServiceImpl implements BaseDataService {
	
	
	@Override
	public Map<String, Object> getRealTimeData(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getHistoryData(String code, Date start,
			Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
