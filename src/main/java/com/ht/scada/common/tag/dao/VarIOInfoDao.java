package com.ht.scada.common.tag.dao;

import com.ht.scada.common.tag.entity.VarIOInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * 作者: "薄成文"
 * 日期: 13-5-16 下午2:03
 * To change this template use File | Settings | File Templates.
 */
public interface VarIOInfoDao extends JpaRepository<VarIOInfo, Integer> {
}
