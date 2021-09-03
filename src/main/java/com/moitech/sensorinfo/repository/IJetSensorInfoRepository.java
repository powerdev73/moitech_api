package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetSensorInfo;

public interface IJetSensorInfoRepository {
    public JetSensorInfo findOne(String nodeId);
    public String save(JetSensorInfo jetSensorInfo);
}
