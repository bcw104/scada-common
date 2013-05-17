package com.ht.scada.common.tag.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.type.VarGroupType;
import com.ht.scada.common.tag.type.VarSubType;
import com.ht.scada.common.tag.type.VarType;
import com.ht.scada.common.tag.type.dao.VarGroupTypeDao;
import com.ht.scada.common.tag.type.dao.VarSubTypeDao;
import com.ht.scada.common.tag.type.dao.VarTypeDao;
import com.ht.scada.common.tag.type.service.TypeService;

@Transactional
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private VarTypeDao varTypeDao;
	@Autowired
	private VarSubTypeDao varSubTypeDao;
	@Autowired
	private VarGroupTypeDao varGroupTypeDao;
	
	
	@Override
	public void insertVarGroupType(VarGroupType varGroupType) {
		varGroupTypeDao.save(varGroupType);
	}
	@Override
	public void insertVarType(VarType varType) {
		varTypeDao.save(varType);
		
	}
	@Override
	public void insertVarSubType(VarSubType varSubType) {
		varSubTypeDao.save(varSubType);
	}
	
	@Override
	public void insertVarGroupTypeList(List<VarGroupType> varGroupTypeList) {
		varGroupTypeDao.save(varGroupTypeList);
		
	}
	@Override
	public void insertVarTypeList(List<VarType> varTypeList) {
		varTypeDao.save(varTypeList);
	}
	@Override
	public void insertVarSubTypeList(List<VarSubType> varSubTypeList) {
		varSubTypeDao.save(varSubTypeList);
	}
	
	
	/**
	 * 油田项目初始化
	 */
	public void initOilProject() {
		
	}
	

}
