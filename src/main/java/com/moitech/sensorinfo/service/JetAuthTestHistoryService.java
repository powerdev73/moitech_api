package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.repository.JetAuthTestHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JetAuthTestHistoryService {

    private final JetAuthTestHistoryRepository jetAuthTestHistoryRepository;

    public List<JetAuthTestHistory> findAll(){
        return jetAuthTestHistoryRepository.findAll();
    }

    public Long save(JetAuthTestHistory jetAuthTestHistory){
        return jetAuthTestHistoryRepository.save(jetAuthTestHistory);
    }

    public List<JetAuthTestHistory> findByUpdateNow(String nowDate){
        return jetAuthTestHistoryRepository.findByUpdateNow(nowDate);
    }

    public JetAuthTestHistory findByIdx(Long idx){
        return jetAuthTestHistoryRepository.findOne(idx);
    }
}
