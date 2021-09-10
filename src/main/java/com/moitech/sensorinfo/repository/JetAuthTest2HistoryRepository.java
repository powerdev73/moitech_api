package com.moitech.sensorinfo.repository;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JetAuthTest2HistoryRepository implements IJetAuthTest2HistoryRepository {

    private final EntityManager em;

    @Override
    public List<JetAuthTest2History> findAll() {
        return em.createQuery("SELECT S FROM JetAuthTest2History S", JetAuthTest2History.class).getResultList();
    }

    @Override
    public List<JetAuthTest2History> findByUpdateNow(String nowDateTime) {
        Date argDate = null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            argDate = simpleDateFormat.parse(nowDateTime);

        } catch(ParseException ex){
            return null;
        }
        return em.createQuery("SELECT S FROM JetAuthTest2History S WHERE S.createDttm > :nowDateTime", JetAuthTest2History.class)
                .setParameter("nowDateTime", argDate)
                .getResultList();
    }

    @Override
    public JetAuthTest2History findOne(Long idx) {
        return em.find(JetAuthTest2History.class, idx);
    }

    @Override
    public Long save(JetAuthTest2History jetAuthTest2History) {
        em.persist(jetAuthTest2History);
        return jetAuthTest2History.getIdx();
    }
}
