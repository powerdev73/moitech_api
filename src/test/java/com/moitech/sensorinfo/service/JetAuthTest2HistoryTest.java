package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTest2History;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JetAuthTest2HistoryTest {
    @Autowired
    JetAuthTest2HistoryService jetAuthTest2HistoryService;
    @Autowired
    EntityManager em;

    @Test
    public void 정보_저장_테스트() {
        //Give
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss:SSS");
        String nowDateTime = simpleDateFormat.format(new Date());
        Date dateToday = new Date();

        JetAuthTest2History jetAuthTest2History1
                = createJetAuthTest2History(
                "TECHHIVE", "20210825_1", nowDateTime,
                123, 23, dateToday);

        //When
        Long idx1 = jetAuthTest2HistoryService.save(jetAuthTest2History1);

        //Then
        assertEquals(jetAuthTest2History1, jetAuthTest2HistoryService.findByIdx(idx1));
    }

    @Test
    public void 지정시간이후_리스트_테스트() {
        //Given
        Date dateToday = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateToday);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        cal.add(Calendar.MINUTE, 3);
        System.out.println(cal.getTime());
        String prevDateTime = simpleDateFormat1.format(cal.getTime());
        cal.add(Calendar.MINUTE, -3);
        System.out.println(cal.getTime());
        String nextDateTime = simpleDateFormat1.format(cal.getTime());

        JetAuthTest2History jetAuthTest2History1
                = createJetAuthTest2History(
                "TECHHIVE", "20210825_1", prevDateTime,
                123, 23, dateToday);
        JetAuthTest2History jetAuthTest2History2
                = createJetAuthTest2History(
                "TECHHIVE", "20210825_1", nextDateTime,
                123, 23, dateToday);

        try{
            List<JetAuthTest2History> resultList = jetAuthTest2HistoryService.findByUpdateNow(simpleDateFormat1.format(dateToday));
            for (JetAuthTest2History m : resultList) {
                System.out.println("m.getFacilityId() = " + m.getFacilityId());
                System.out.println("m.getNodeId() = " + m.getNodeId());
            }
        }
        catch (IllegalStateException e) {
            e.printStackTrace();        }
    }

    public JetAuthTest2History createJetAuthTest2History(
            String facilityId,
            String nodeId,
            String presentationTime,
            Integer tsi1Pm25,
            Integer tsi2Pm25,
            Date createDttm)
    {
        JetAuthTest2History jetAuthTest2History = new JetAuthTest2History();
        jetAuthTest2History.setFacilityId(facilityId);
        jetAuthTest2History.setNodeId(nodeId);
        jetAuthTest2History.setPresentationTime(presentationTime);
        jetAuthTest2History.setTsi1Pm10(tsi1Pm25);
        jetAuthTest2History.setTsi2Pm25(tsi2Pm25);
        jetAuthTest2History.setCreateDttm(createDttm);
        return jetAuthTest2History;
    }
}
