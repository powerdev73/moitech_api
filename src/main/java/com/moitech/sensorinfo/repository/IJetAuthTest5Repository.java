package com.moitech.sensorinfo.repository;
import com.moitech.sensorinfo.domain.JetAuthTest5History;

import java.util.List;

public interface IJetAuthTest5Repository {
    public List<JetAuthTest5History> findAll();
    public List<JetAuthTest5History> findByUpdateNow(String nowDateTime);
    public JetAuthTest5History findOne(Long idx);
    public Long save(JetAuthTest5History jetAuthTest5History);
}
