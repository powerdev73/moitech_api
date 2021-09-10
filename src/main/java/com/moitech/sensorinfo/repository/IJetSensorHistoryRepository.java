package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.domain.JetSensorHistory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IJetSensorHistoryRepository {
    public List<JetSensorHistory> findAll();
    public List<JetSensorHistory> findByUpdateNow(String nowDateTime);
    public Long save(JetSensorHistory jetSensorHistory);
    public JetSensorHistory findOne(Long idx);
}
