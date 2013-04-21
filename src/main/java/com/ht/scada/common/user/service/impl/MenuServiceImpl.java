package com.ht.scada.common.user.service.impl;

import com.ht.scada.common.user.dao.MenuItemDao;
import com.ht.scada.common.user.dao.MenuTypeDao;
import com.ht.scada.common.user.entity.MenuItem;
import java.util.List;

import com.ht.scada.common.user.entity.MenuType;
import com.ht.scada.common.user.service.MenuService;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Inject
	private MenuItemDao menuItemDao;
        @Inject
	private MenuTypeDao menuTypeDao;
        @Override
	public List<MenuType> getAllMenuTypes() {
		return menuTypeDao.findAll();
	}
        @Override
        public List<MenuItem> getAllMenuItem(){
            return menuItemDao.findAll();
        }
       
}
