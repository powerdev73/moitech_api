package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTest5History;
import com.moitech.sensorinfo.domain.JetAuthTestHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JetAuthTest5HistoryRepository implements IJetAuthTest5Repository{

    private final EntityManager em;

    @Override
    public List<JetAuthTest5History> findAll() {
        return em.createQuery("SELECT S FROM JetAuthTest5History S", JetAuthTest5History.class).getResultList();
    }

    @Override
    public List<JetAuthTest5History> findByUpdateNow(String nowDateTime) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            Date argDate = simpleDateFormat.parse(nowDateTime);
            return em.createQuery("SELECT S FROM JetAuthTest5History S WHERE S.createDttm > :nowDateTime", JetAuthTest5History.class)
                    .setParameter("nowDateTime", argDate)
                    .getResultList();
        } catch(ParseException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public JetAuthTest5History findOne(Long idx) {
        return em.find(JetAuthTest5History.class, idx);
    }

    @Override
    public Long save(JetAuthTest5History jetAuthTest5History) {
        em.persist(jetAuthTest5History);
        return jetAuthTest5History.getIdx();
    }
}
