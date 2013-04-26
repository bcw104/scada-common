package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.service.AcquisitionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bcw
 * Date: 13-4-25
 * Time: 下午7:09
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("acquisitionService")
public class AcquisitionServiceImpl implements AcquisitionService {
    @Override
    public List<AcquisitionChannel> getAllChannel() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getChannelSize() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getDeviceSizeByChannel(int channelID) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AcquisitionChannel getChannel(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AcquisitionDevice getDevice(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AcquisitionDevice getDeviceByChannelAndAddress(int channelID, int address) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
