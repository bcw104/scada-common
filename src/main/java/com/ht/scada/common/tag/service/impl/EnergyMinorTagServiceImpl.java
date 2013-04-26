package com.ht.scada.common.tag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.EnergyMinorTagDao;
import com.ht.scada.common.tag.entity.EnergyMinorTag;
import com.ht.scada.common.tag.service.EnergyMinorTagService;

@Transactional
@Service("energyMinorTagService")
public class EnergyMinorTagServiceImpl implements EnergyMinorTagService {
	@Autowired
	private EnergyMinorTagDao energyMinorTagDao;

	@Override
	public void create(EnergyMinorTag domain) {
		energyMinorTagDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		energyMinorTagDao.delete(id);
	}

	@Override
	public void update(EnergyMinorTag domain) {
		energyMinorTagDao.save(domain);
	}

	@Override
	public EnergyMinorTag getById(int id) {
		return energyMinorTagDao.findOne(id);
	}

}
