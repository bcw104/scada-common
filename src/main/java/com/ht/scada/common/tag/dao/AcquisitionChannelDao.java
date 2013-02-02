package com.ht.scada.common.tag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.AcquisitionChannel;

public interface AcquisitionChannelDao extends JpaRepository<AcquisitionChannel, Integer> {

}
