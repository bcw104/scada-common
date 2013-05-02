package com.ht.scada.common.tag.service.impl;

import java.util.List;

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

	@Override
	public List<EnergyMinorTag> getEnergyMinorTagsByParentId(int parentId) {
		EnergyMinorTag parentMajor = energyMinorTagDao.findOne(parentId);
		if(parentMajor == null) {
			return null;
		}
		return energyMinorTagDao.findByParent(parentMajor);
	}

	@Override
	public List<EnergyMinorTag> getRootEnergyMinorTag() {
		return energyMinorTagDao.findByParent(null);
	}

}
