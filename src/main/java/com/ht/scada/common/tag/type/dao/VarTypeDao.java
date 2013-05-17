package com.ht.scada.common.tag.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.type.VarType;

public interface VarTypeDao extends JpaRepository<VarType, Integer> {

}
