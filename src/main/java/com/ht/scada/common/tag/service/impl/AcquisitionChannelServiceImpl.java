package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AcquisitionChannelDao;
import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.service.AcquisitionChannelService;
import com.ht.scada.common.tag.util.CommunicationProtocal;

@Transactional
@Service("acquisitionChannelService")
public class AcquisitionChannelServiceImpl implements AcquisitionChannelService {

	@Autowired
	private AcquisitionChannelDao acquisitionChannelDao;

	
	@Override
	public List<AcquisitionChannel> getRootAcquisitionChannel() {
		return acquisitionChannelDao.findAll();
	}

	@Override
	public List<AcquisitionChannel> getDeviceByChannelId(Integer channelId) {
		AcquisitionChannel parentMajor = acquisitionChannelDao
				.findOne(channelId);
		if (parentMajor == null) {
			return null;
		}
		return acquisitionChannelDao.findAll();
	}

	@Override
	public void create(AcquisitionChannel domain) {
		acquisitionChannelDao.save(domain);
		
	}

	@Override
	public void deleteById(int id) {
		acquisitionChannelDao.delete(id);
	}

	@Override
	public void update(AcquisitionChannel domain) {
		AcquisitionChannel a = new AcquisitionChannel();
		a.setIdx(22);
		a.setName("344");
		a.setFrames("eeeee");
		a.setPortInfo("dddd");
		a.setProtocal(CommunicationProtocal.IEC104);
		
		acquisitionChannelDao.save(a);
		
	}

	@Override
	public AcquisitionChannel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
