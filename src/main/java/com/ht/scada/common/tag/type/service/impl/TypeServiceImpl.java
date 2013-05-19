package com.ht.scada.common.tag.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.VarGroupCfgDao;
import com.ht.scada.common.tag.entity.VarGroupCfg;
import com.ht.scada.common.tag.type.EndTagExtInfoName;
import com.ht.scada.common.tag.type.EndTagExtInfoValue;
import com.ht.scada.common.tag.type.EndTagSubType;
import com.ht.scada.common.tag.type.EndTagType;
import com.ht.scada.common.tag.type.MajorTagType;
import com.ht.scada.common.tag.type.VarSubType;
import com.ht.scada.common.tag.type.VarType;
import com.ht.scada.common.tag.type.dao.EndTagSubTypeDao;
import com.ht.scada.common.tag.type.dao.EndTagTypeDao;
import com.ht.scada.common.tag.type.dao.MajorTagTypeDao;
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
	private VarGroupCfgDao varGroupCfgDao;
	@Autowired
	private MajorTagTypeDao majorTagTypeDao;
	@Autowired
	private EndTagTypeDao endTagTypeDao;
	@Autowired
	private EndTagSubTypeDao endTagSubTypeDao;
	
	@Override
	public void insertMajorTagType(MajorTagType majorTagType) {
		majorTagTypeDao.save(majorTagType);
	}
	@Override
	public void insertEndTagType(EndTagType endTagType) {
		endTagTypeDao.save(endTagType);
	}
	
	@Override
	public void insertEndTagSubType(EndTagSubType endTagSubType) {
		endTagSubTypeDao.save(endTagSubType);
	}
	@Override
	public void insertVarGroupCgf(VarGroupCfg varGroupCfg) {
		varGroupCfgDao.save(varGroupCfg);
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
	public void insertVarGroupCfg(List<VarGroupCfg> varGroupCfgList) {
		varGroupCfgDao.save(varGroupCfgList);
		
	}
	@Override
	public void insertVarType(List<VarType> varTypeList) {
		varTypeDao.save(varTypeList);
	}
	@Override
	public void insertVarSubType(List<VarSubType> varSubTypeList) {
		varSubTypeDao.save(varSubTypeList);
	}
	

	@Override
	public List<VarGroupCfg> getAllVarGroupCfg() {
		return varGroupCfgDao.findAll();
	}
	@Override
	public List<VarType> getAllVarType() {
		return varTypeDao.findAll();
	}
	@Override
	public List<MajorTagType> getAllMajorTagType() {
		return majorTagTypeDao.findAll();
	}
	@Override
	public List<EndTagType> getAllEndTagType() {
		return endTagTypeDao.findAll();
	}
	@Override
	public List<EndTagSubType> getSubTypeByEndTagTypeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagSubType> getSubTypeByEndTagTypeValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VarSubType> getAllVarSubType() {
		return varSubTypeDao.findAll();
	}
	@Override
	public List<VarSubType> getVarSubTypeByGroupName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VarSubType> getVarSubTypeByGroupValue(String groupValue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VarSubType> getVarSubTypeByVarTypeName(String varTypeName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VarSubType> getVarSubTypeByVarTypeValue(String varTypeValue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagName(
			String endTagTypeName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagValue(
			String endTagTypeNValue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoName(String infoName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoValue(String infoValue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertMajorTagType(List<MajorTagType> majorTagTypeList) {
		majorTagTypeDao.save(majorTagTypeList);
		
	}
	@Override
	public void insertEndTagType(List<EndTagType> endTagTypeList) {
		endTagTypeDao.save(endTagTypeList);
		
	}
	@Override
	public void insertEndTagSubType(List<EndTagSubType> endTagSubTypeList) {
		endTagSubTypeDao.save(endTagSubTypeList);
		
	}
	

	

}
