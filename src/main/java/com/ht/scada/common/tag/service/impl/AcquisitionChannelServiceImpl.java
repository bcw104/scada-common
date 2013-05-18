package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.dao.AcquisitionChannelDao;
import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.service.AcquisitionChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<AcquisitionChannel> getAllChannel() {
        return acquisitionChannelDao.findAll();  //To change body of implemented methods use File | Settings | File Templates.
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
		acquisitionChannelDao.save(domain);
		
	}

	@Override
	public AcquisitionChannel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
