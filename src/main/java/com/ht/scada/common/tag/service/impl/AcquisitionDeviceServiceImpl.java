package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AcquisitionChannelDao;
import com.ht.scada.common.tag.dao.AcquisitionDeviceDao;
import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.service.AcquisitionDeviceService;

@Transactional
@Service("acquisitionDeviceService")
public class AcquisitionDeviceServiceImpl implements AcquisitionDeviceService {
	@Autowired
	AcquisitionDeviceDao acquisitionDeviceDao;
	@Autowired
	AcquisitionChannelDao acquisitionChannelDao;

	@Override
	public List<AcquisitionDevice> getDeviceByChannelId(Integer id) {
		AcquisitionChannel channelObject = acquisitionChannelDao.findOne(id);
		if(channelObject == null) {
			return null;
		}
		return acquisitionDeviceDao.findByChannel(channelObject);
	}

	@Override
	public void create(AcquisitionDevice acquisitionDevice) {
		acquisitionDeviceDao.save(acquisitionDevice);
	}

	@Override
	public void deleteById(int id) {
		acquisitionDeviceDao.delete(id);
		
	}

	@Override
	public void update(AcquisitionDevice domain) {
		acquisitionDeviceDao.saveAndFlush(domain);
		
	}

	@Override
	public AcquisitionDevice getById(int id) {
		return acquisitionDeviceDao.findOne(id);
	}

}
