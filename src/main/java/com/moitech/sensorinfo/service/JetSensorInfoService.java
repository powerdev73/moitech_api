package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetSensorInfo;
import com.moitech.sensorinfo.repository.JetSensorInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JetSensorInfoService {

    private final JetSensorInfoRepository jetSensorInfoRepository;

    public JetSensorInfo findJetSensorInfoByNodeId(String nodeId) {
        return jetSensorInfoRepository.findOne(nodeId);
    }

    public String saveJetSensorInfo(JetSensorInfo jetSensorInfo){
        return jetSensorInfoRepository.save(jetSensorInfo);
    }
}
