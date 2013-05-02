package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AreaMinorTagDao;
import com.ht.scada.common.tag.dao.EndTagDao;
import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.AreaMinorTag;
import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.entity.VarIOInfo;
import com.ht.scada.common.tag.service.TagService;
@Transactional
@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private MajorTagDao majorTagDao;
	@Autowired
	private EndTagDao endTagDao;
	@Autowired
	private AreaMinorTagDao areaMinorTagDao;

	@Override
	public MajorTag getMajorTag(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EndTag getEndTag(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagCfgTpl getTagCfgTpl(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagTplNameByMajorTagID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagCfgTpl> getTagTplByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MajorTag> getMajorTagByNodeName(String name) {
		MajorTag parentMajor = majorTagDao.findByName(name);
		if(parentMajor == null) {
			return null;
		}
		return majorTagDao.findByParent(parentMajor);
	}

	@Override
	public List<EndTag> getEndTagByMajorTagAndType(int majorTagID, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SensorDevice> getSensorDeviceByRTUDeviceID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AcquisitionDevice> getDeviceByChannelName(String name) {
		return null;
	}

	@Override
	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createMajorTag(MajorTag majorTag) {
		majorTagDao.save(majorTag);
	}

	@Override
	public void deleteMajorTagById(int id) {
		majorTagDao.delete(id);
	}

	@Override
	public void updateMajorTag(MajorTag majorTag) {
		majorTagDao.save(majorTag);
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

	@Override
	public void createEndTag(EndTag endTag) {
		endTagDao.save(endTag);
	}

	@Override
	public List<EndTag> getEndTagByParentId(int id) {
		MajorTag parentMajor = majorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return endTagDao.findByMajorTag(parentMajor);
	}

	@Override
	public void deleteEndTagById(int id) {
		endTagDao.delete(id);
	}

	@Override
	public void updateEndTag(EndTag endTag) {
		endTagDao.save(endTag);
	}

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
	public void deleteAreaMinorTagById(int id) {
		areaMinorTagDao.delete(id);
	}

	@Override
	public void createAreaMinorTag(AreaMinorTag areaMinorTag) {
		areaMinorTagDao.save(areaMinorTag);
		
	}

	@Override
	public void updateAreaMinorTag(AreaMinorTag areaMinorTag) {
		areaMinorTagDao.save(areaMinorTag);
		
	}
}
