package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.service.TagService;
@Transactional
@Service("tagService")
public class TagServiceImpl implements TagService {

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
