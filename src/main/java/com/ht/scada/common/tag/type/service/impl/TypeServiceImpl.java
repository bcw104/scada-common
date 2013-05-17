package com.ht.scada.common.tag.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.type.EndTagExtInfoName;
import com.ht.scada.common.tag.type.EndTagExtInfoValue;
import com.ht.scada.common.tag.type.EndTagSubType;
import com.ht.scada.common.tag.type.EndTagType;
import com.ht.scada.common.tag.type.MajorTagType;
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
	@Override
	public List<VarGroupType> getAllVarGroupType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VarType> getAllVarType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MajorTagType> getAllMajorTagType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EndTagType> getAllEndTagType() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
	

}
