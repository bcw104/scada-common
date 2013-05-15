package com.ht.scada.common.tag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.VarGroupCfg;
/**
 * 变量分组
 * 
 * @author 陈志强
 * 
 */
public interface VarGroupCfgDao extends JpaRepository<VarGroupCfg, Integer> {

}
