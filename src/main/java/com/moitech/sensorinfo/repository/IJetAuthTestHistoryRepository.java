package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;

import java.time.LocalDateTime;
import java.util.List;

public interface IJetAuthTestHistoryRepository {
    public List<JetAuthTestHistory> findAll();
    public List<JetAuthTestHistory> findByUpdateNow(String nowDateTime);
    public Long save(JetAuthTestHistory jetAuthTestHistory);
    public JetAuthTestHistory findOne(Long idx);
}
