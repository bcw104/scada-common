package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.service.MajorTagService;

@Transactional
@Service("majorTagService")
public class MajorTagServiceImpl implements MajorTagService {
	@Autowired
	private MajorTagDao majorTagDao;
	

	@Override
	public void create(MajorTag domain) {
		majorTagDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		majorTagDao.delete(id);
	}

	@Override
	public void update(MajorTag domain) {
		majorTagDao.save(domain);
	}

	@Override
	public MajorTag getById(int id) {
		return majorTagDao.findOne(id);
	}

	@Override
	public List<MajorTag> getMajorTagsByParentId(int id) {
		MajorTag parentMajor = majorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return majorTagDao.findByParent(parentMajor);
	}
	
	@Override
	public List<MajorTag> getRootMajorTag() {
		return majorTagDao.findByParent(null);
	}

}
