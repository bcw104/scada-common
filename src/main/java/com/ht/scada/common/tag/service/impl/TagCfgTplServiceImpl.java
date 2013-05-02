package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.dao.TagCfgTplDao;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.service.TagCfgTplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("tagCfgTplService")
public class TagCfgTplServiceImpl implements TagCfgTplService {
	
	@Autowired
	private TagCfgTplDao tagCfgTplDao;

	@Override
	public void create(TagCfgTpl domain) {
		tagCfgTplDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		tagCfgTplDao.delete(id);
	}

	@Override
	public void update(TagCfgTpl domain) {
		tagCfgTplDao.save(domain);
	}

	@Override
	public TagCfgTpl getById(int id) {
		return tagCfgTplDao.findOne(id);
	}

	@Override
	public List<String> findAllTplName() {
		return tagCfgTplDao.findDistinctByTplName();
	}

    @Override
    public List<TagCfgTpl> getAllTagTpl() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
