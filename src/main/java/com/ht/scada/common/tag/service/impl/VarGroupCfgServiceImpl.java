package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.VarGroupCfgDao;
import com.ht.scada.common.tag.entity.VarGroupCfg;
import com.ht.scada.common.tag.service.VarGroupCfgService;

/**
 * 变量分组
 * 
 * @author 陈志强
 * 
 */
@Transactional
@Service("varGroupCfgService")
public class VarGroupCfgServiceImpl implements VarGroupCfgService {

	@Autowired
	private VarGroupCfgDao varGroupCfgDao;

	@Override
	public void create(VarGroupCfg domain) {
		varGroupCfgDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		varGroupCfgDao.delete(id);
	}

	@Override
	public void update(VarGroupCfg domain) {
		varGroupCfgDao.save(domain);
	}

	@Override
	public VarGroupCfg getById(int id) {
		return varGroupCfgDao.findOne(id);
	}

	@Override
	public List<VarGroupCfg> getAllVarGroupCfg() {
		return varGroupCfgDao.findAll();
	}

}
