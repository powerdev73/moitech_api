package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import com.moitech.sensorinfo.domain.JetAuthTest5History;
import com.moitech.sensorinfo.repository.JetAuthTest2HistoryRepository;
import com.moitech.sensorinfo.repository.JetAuthTest5HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JetAuthTest2HistoryService {
    private final JetAuthTest2HistoryRepository jetAuthTest2HistoryRepository;

    public List<JetAuthTest2History> findAll(){
        return jetAuthTest2HistoryRepository.findAll();
    }

    public Long save(JetAuthTest2History jetAuthTest2History){
        return jetAuthTest2HistoryRepository.save(jetAuthTest2History);
    }

    public List<JetAuthTest2History> findByUpdateNow(String nowDate){
        return jetAuthTest2HistoryRepository.findByUpdateNow(nowDate);
    }

    public JetAuthTest2History findByIdx(Long idx){
        return jetAuthTest2HistoryRepository.findOne(idx);
    }
}
