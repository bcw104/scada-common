package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AreaMinorTagDao;
import com.ht.scada.common.tag.entity.AreaMinorTag;
import com.ht.scada.common.tag.service.AreaMinorTagService;

@Transactional
@Service("areaMinorTagService")
public class AreaMinorTagServiceImpl implements AreaMinorTagService {
	@Autowired
	private AreaMinorTagDao areaMinorTagDao;
	
	@Override
	public List<AreaMinorTag> getRootAreaMinorTag() {
		return areaMinorTagDao.findByParent(null);
	}

	@Override
	public List<AreaMinorTag> getAreaMinorTagsByParentId(Integer id) {
		AreaMinorTag parentMajor = areaMinorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return areaMinorTagDao.findByParent(parentMajor);
	}

	@Override
	public void create(AreaMinorTag domain) {
		areaMinorTagDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		areaMinorTagDao.delete(id);
	}

	@Override
	public void update(AreaMinorTag domain) {
		areaMinorTagDao.save(domain);
	}

	@Override
	public AreaMinorTag getById(int id) {
		return areaMinorTagDao.findOne(id);
	}

}
