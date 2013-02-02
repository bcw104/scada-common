package com.ht.scada.common.tag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.AcquisitionDevice;

public interface AcquisitionDeviceDao extends JpaRepository<AcquisitionDevice, Integer> {

}
