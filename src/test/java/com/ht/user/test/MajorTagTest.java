package com.ht.user.test;

import java.util.Arrays;
import java.util.HashSet;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.service.TagService;
import com.ht.scada.common.user.dao.UserDao;
import com.ht.scada.common.user.entity.User;
import com.ht.scada.common.user.entity.UserRole;
import com.ht.scada.common.user.service.UserService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MajorTagTest {
	private static final Logger log = LoggerFactory.getLogger(MajorTag.class);
	
	@Autowired
	private MajorTagDao majorTagDao;
	@Autowired
	private TagService tagService;

	@Test
	public void test() {
		
		MajorTag mt = new MajorTag();
		mt.setName("test2");
		
		majorTagDao.save(mt);
//		tagService.createMajorTag(mt);
	}

//	@BeforeTest
	public void beforeTest() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 majorTagDao = (MajorTagDao) context.getBean("majorTagDao");  
		 tagService = (TagService)context.getBean("tagService");  
		 
		 log.info("before Test");

	}

}
