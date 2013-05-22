package com.ht.scada.common.tag.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.type.entity.VarType;

public interface VarTypeDao extends JpaRepository<VarType, Integer> {

}
