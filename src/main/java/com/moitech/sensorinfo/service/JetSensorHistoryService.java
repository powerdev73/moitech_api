package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.domain.JetSensorHistory;
import com.moitech.sensorinfo.domain.JetSensorInfo;
import com.moitech.sensorinfo.repository.JetSensorHistoryRepository;
import com.moitech.sensorinfo.repository.JetSensorInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JetSensorHistoryService {
    private final JetSensorHistoryRepository jetSensorHistoryRepository;

    public JetSensorHistory findByIdx(Long idx){
        return jetSensorHistoryRepository.findOne(idx);
    }

    public List<JetSensorHistory> findAll(){
        return jetSensorHistoryRepository.findAll();
    }

    public List<JetSensorHistory> findByUpdateNow(String nowDate){
        return jetSensorHistoryRepository.findByUpdateNow(nowDate);
    }

    public Long save(JetSensorHistory jetSensorHistory){
        return jetSensorHistoryRepository.save(jetSensorHistory);
    }
}
