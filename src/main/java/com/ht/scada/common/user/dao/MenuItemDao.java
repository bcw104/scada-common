/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.common.user.dao;


import com.ht.scada.common.user.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */
public interface MenuItemDao extends JpaRepository<MenuItem, Integer>{
    
}
