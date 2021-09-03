package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetSensorInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class JetSensorInfoRepository implements IJetSensorInfoRepository{
    private final EntityManager em;

    @Override
    public JetSensorInfo findOne(String nodeId) {
        return em.find(JetSensorInfo.class, nodeId);
    }

    @Override
    public String save(JetSensorInfo jetSensorInfo) {
        em.persist(jetSensorInfo);
        return jetSensorInfo.getNodeId();
    }

}
