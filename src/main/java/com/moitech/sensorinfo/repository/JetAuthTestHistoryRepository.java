package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
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
public class JetAuthTestHistoryRepository implements IJetAuthTestHistoryRepository{
    private final EntityManager em;

    @Override
    public List<JetAuthTestHistory> findAll() {
        return em.createQuery("SELECT S FROM JetAuthTestHistory S", JetAuthTestHistory.class).getResultList();
    }

    @Override
    public List<JetAuthTestHistory> findByUpdateNow(String nowDateTime) {

        Date argDate = null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            argDate = simpleDateFormat.parse(nowDateTime);

        } catch(ParseException ex) {
            ex.printStackTrace();
        }

        return em.createQuery("SELECT S FROM JetAuthTestHistory S WHERE S.createDttm >= :nowDateTime", JetAuthTestHistory.class)
                .setParameter("nowDateTime", argDate)
                .getResultList();
    }

    @Override
    public Long save(JetAuthTestHistory jetAuthTestHistory) {
        em.persist(jetAuthTestHistory);
        return jetAuthTestHistory.getIdx();
    }

    @Override
    public JetAuthTestHistory findOne(Long idx) {
        return em.find(JetAuthTestHistory.class, idx);
    }
}
