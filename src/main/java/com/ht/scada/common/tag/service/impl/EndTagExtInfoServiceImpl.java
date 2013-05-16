package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.EndTagExtInfoDao;
import com.ht.scada.common.tag.entity.EndTagExtInfo;
import com.ht.scada.common.tag.service.EndTagExtInfoService;
/**
 * 末端节点扩展信息
 * 
 * @author 陈志强
 * 
 */
@Transactional
@Service("endTagExtInfoService")
public class EndTagExtInfoServiceImpl implements EndTagExtInfoService {

	@Autowired
	private EndTagExtInfoDao endTagExtInfoDao;
	
	@Override
	public void create(EndTagExtInfo domain) {
		endTagExtInfoDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		endTagExtInfoDao.delete(id);
	}

	@Override
	public void update(EndTagExtInfo domain) {
		endTagExtInfoDao.save(domain);
	}

	@Override
	public EndTagExtInfo getById(int id) {
		return endTagExtInfoDao.findOne(id);
	}

	@Override
	public List<EndTagExtInfo> getByEndTagId(int endTagId) {
		return endTagExtInfoDao.getByEndTagId(endTagId);
	}

}
