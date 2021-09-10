package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import com.moitech.sensorinfo.domain.JetAuthTestHistory;

import java.util.List;

public interface IJetAuthTest2Repository {
    public List<JetAuthTest2History> findAll();
    public List<JetAuthTest2History> findByUpdateNow(String nowDateTime);
    public JetAuthTest2History findOne(Long idx);
    public Long save(JetAuthTest2History jetAuthTest2History);
}
