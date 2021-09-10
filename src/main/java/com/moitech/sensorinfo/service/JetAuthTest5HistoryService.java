package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTest5History;
import com.moitech.sensorinfo.repository.JetAuthTest5HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JetAuthTest5HistoryService {
    private final JetAuthTest5HistoryRepository jetAuthTest5HistoryRepository;

    public List<JetAuthTest5History> findAll(){
        return jetAuthTest5HistoryRepository.findAll();
    }

    public Long save(JetAuthTest5History jetAuthTest5History){
        return jetAuthTest5HistoryRepository.save(jetAuthTest5History);
    }

    public List<JetAuthTest5History> findByUpdateNow(String nowDate){
        return jetAuthTest5HistoryRepository.findByUpdateNow(nowDate);
    }

    public JetAuthTest5History findByIdx(Long idx){
        return jetAuthTest5HistoryRepository.findOne(idx);
    }
}
