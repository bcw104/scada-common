package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AreaMinorTagDao;
import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
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
	private AreaMinorTagDao areaMinorTagDao;


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

	

}
