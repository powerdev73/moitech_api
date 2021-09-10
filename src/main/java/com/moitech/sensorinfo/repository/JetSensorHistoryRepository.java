package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import com.moitech.sensorinfo.domain.JetSensorHistory;
import com.moitech.sensorinfo.domain.JetSensorInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JetSensorHistoryRepository implements IJetSensorHistoryRepository {

    private final EntityManager em;

    @Override
    public List<JetSensorHistory> findAll() {
        return em.createQuery("SELECT S FROM JetSensorHistory S", JetSensorHistory.class).getResultList();
    }

    @Override
    public List<JetSensorHistory> findByUpdateNow(String nowDateTime) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            Date argDate = simpleDateFormat.parse(nowDateTime);
            return em.createQuery("SELECT S FROM JetAuthTestHistory S WHERE S.createDttm > :nowDateTime", JetSensorHistory.class)
                    .setParameter("nowDateTime", argDate)
                    .getResultList();
        } catch(ParseException ex){
            return null;
        }
    }

    @Override
    public Long save(JetSensorHistory jetSensorHistory) {
        em.persist(jetSensorHistory);
        return jetSensorHistory.getIdx();
    }

    @Override
    public JetSensorHistory findOne(Long idx) {
        return em.find(JetSensorHistory.class, idx);
    }
}
