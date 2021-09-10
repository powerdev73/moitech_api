package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import com.moitech.sensorinfo.domain.JetAuthTest5History;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JetAuthTest5HistoryTest {
    @Autowired
    JetAuthTest5HistoryService jetAuthTest5HistoryService;
    @Autowired
    EntityManager em;

    @Test
    public void 정보_저장_테스트() {
        //Give
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss:SSS");
//        String nowDateTime = simpleDateFormat.format(new Date());
//        Date dateToday = new Date();
//
//        JetAuthTest5History jetAuthTest5History1
//                = createJetAuthTest5History(
//                        dateToday, null, 10, "Y",
//                        null, null);
//
//        //When
//        Long idx1 = jetAuthTest5HistoryService.save(jetAuthTest5History1);
//
//        //Then
//        assertEquals(jetAuthTest5History1, jetAuthTest5HistoryService.findByIdx(idx1));

    }

    public JetAuthTest5History createJetAuthTest5History(
            Date startDttm,
            Date endDttm,
            Integer deliveryTime,
            String cmdYn,
            Date createDttm,
            Date updateDttm)
    {
        JetAuthTest5History jetAuthTest5History = new JetAuthTest5History();
        jetAuthTest5History.setStartDttm(startDttm);
        jetAuthTest5History.setEndDttm(endDttm);
        jetAuthTest5History.setDeliveryTime(deliveryTime);
        jetAuthTest5History.setCmdYn(cmdYn);
        jetAuthTest5History.setCreateDttm(createDttm);
        jetAuthTest5History.setUpdateDttm(updateDttm);

        return jetAuthTest5History;
    }
}
