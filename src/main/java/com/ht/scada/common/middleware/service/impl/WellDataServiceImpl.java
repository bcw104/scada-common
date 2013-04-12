package com.ht.scada.common.middleware.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.ht.scada.common.middleware.service.WellService;
import com.ht.scada.common.well.WellData;
import com.ht.scada.common.well.WellStatus;

/**
 * @author 薄成文
 * @author 赵磊
 *
 */
public class WellDataServiceImpl implements WellService {
	
	@Override
	public void saveWellSGTData(String code, float[] zaihe, float[] weiyi,
			float chongcheng, float chongci) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public WellData getLatestWellDataByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLatestProductByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLatestWellFaultByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WellData getWellDataByWellNumAndDatetime(String wellNum,
			Date datetime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDailyOilProduct(String code, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WellStatus> getWellStatus(Collection<String> codes) {
		// TODO Auto-generated method stub
		return null;
	}
}
