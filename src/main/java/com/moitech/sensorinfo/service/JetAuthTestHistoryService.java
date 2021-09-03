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

    public List<JetAuthTestHistory> findJetAuthTestHistories(){
        return jetAuthTestHistoryRepository.findAll();
    }

    public Long saveJetAuthtestHistory(JetAuthTestHistory jetAuthTestHistory){
        return jetAuthTestHistoryRepository.save(jetAuthTestHistory);
    }

    public List<JetAuthTestHistory> findJetAuthTestHistoriesByUpdateNow(LocalDateTime now){
        return jetAuthTestHistoryRepository.findByUpdateNow(LocalDateTime.now());
    }

    public JetAuthTestHistory findJetAuthTestHistoryByIdx(Long idx){
        return jetAuthTestHistoryRepository.findOne(idx);
    }
}
