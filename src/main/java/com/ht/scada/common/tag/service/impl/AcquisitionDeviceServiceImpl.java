package com.ht.scada.common.tag.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.service.AcquisitionDeviceService;

@Transactional
@Service("acquisitionDeviceService")
public class AcquisitionDeviceServiceImpl implements AcquisitionDeviceService {

	@Override
	public void create(AcquisitionDeviceService domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AcquisitionDeviceService domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public AcquisitionDeviceService getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
