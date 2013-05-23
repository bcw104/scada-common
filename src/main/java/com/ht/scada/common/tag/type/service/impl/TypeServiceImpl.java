package com.ht.scada.common.tag.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.VarGroupCfgDao;
import com.ht.scada.common.tag.entity.VarGroupCfg;
import com.ht.scada.common.tag.type.dao.EndTagExtInfoNameDao;
import com.ht.scada.common.tag.type.dao.EndTagExtInfoValueDao;
import com.ht.scada.common.tag.type.dao.EndTagSubTypeDao;
import com.ht.scada.common.tag.type.dao.EndTagTypeDao;
import com.ht.scada.common.tag.type.dao.MajorTagTypeDao;
import com.ht.scada.common.tag.type.dao.VarSubTypeDao;
import com.ht.scada.common.tag.type.dao.VarTypeDao;
import com.ht.scada.common.tag.type.entity.EndTagExtInfoName;
import com.ht.scada.common.tag.type.entity.EndTagExtInfoValue;
import com.ht.scada.common.tag.type.entity.EndTagSubType;
import com.ht.scada.common.tag.type.entity.EndTagType;
import com.ht.scada.common.tag.type.entity.MajorTagType;
import com.ht.scada.common.tag.type.entity.VarSubType;
import com.ht.scada.common.tag.type.entity.VarType;
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
	@Autowired
	private EndTagExtInfoNameDao endTagExtInfoNameDao;
	@Autowired
	private EndTagExtInfoValueDao endTagExtInfoValueDao;
	
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
		return endTagSubTypeDao.findByEndTagTypeName(name);
	}
	@Override
	public List<EndTagSubType> getSubTypeByEndTagTypeValue(String value) {
		return endTagSubTypeDao.findByEndTagTypeValue(value);
	}
	@Override
	public List<VarSubType> getAllVarSubType() {
		return varSubTypeDao.findAll();
	}
	@Override
	public List<VarSubType> getVarSubTypeByGroupName(String groupName) {
		return varSubTypeDao.findByVarGroupName(groupName);
	}
	@Override
	public List<VarSubType> getVarSubTypeByGroupValue(String groupValue) {
		return varSubTypeDao.findByVarGroupValue(groupValue);
	}
	@Override
	public List<VarSubType> getVarSubTypeByVarTypeName(String varTypeName) {
		return varSubTypeDao.findByVarTypeName(varTypeName);
	}
	@Override
	public List<VarSubType> getVarSubTypeByVarTypeValue(String varTypeValue) {
		return varSubTypeDao.findByVarTypeValue(varTypeValue);
	}
	@Override
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagName(
			String endTagTypeName) {
		return endTagExtInfoNameDao.findByEndTagName(endTagTypeName);
	}
	@Override
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagValue(
			String endTagTypeNValue) {
		return endTagExtInfoNameDao.findByEndTagValue(endTagTypeNValue);
	}
	@Override
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoName(String infoName) {
		return endTagExtInfoValueDao.findByExtName(infoName);
	}
	@Override
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoValue(String infoValue) {
		return endTagExtInfoValueDao.findByExtValue(infoValue);
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
	@Override
	public void deleteAllType() {
		endTagExtInfoValueDao.deleteAll();
		endTagExtInfoNameDao.deleteAll();
		varSubTypeDao.deleteAll();
		varTypeDao.deleteAll();
		endTagSubTypeDao.deleteAll();
		varGroupCfgDao.deleteAll();
		endTagTypeDao.deleteAll();
		majorTagTypeDao.deleteAll();
	}
	@Override
	public void insertEndTagExtInfoName(
			List<EndTagExtInfoName> endTagExtInfoNameList) {
		endTagExtInfoNameDao.save(endTagExtInfoNameList);
		
	}
	@Override
	public void insertEndTagExtInfoValue(
			List<EndTagExtInfoValue> endTagExtInfoValueList) {
		endTagExtInfoValueDao.save(endTagExtInfoValueList);
		
	}

}
