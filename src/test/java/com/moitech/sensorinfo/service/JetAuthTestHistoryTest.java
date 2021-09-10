package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
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

public class JetAuthTestHistoryTest {
    @Autowired
    JetAuthTestHistoryService jetAuthTestHistoryService;
    @Autowired
    EntityManager em;

    @Test
    public void 정보_저장_테스트() {
        //Give
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss:SSS");
        String nowDateTime = simpleDateFormat.format(new Date());
        Date dateToday = new Date();

        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                "TECHHIVE", "20210825_1", nowDateTime,
                123, 23, dateToday);

        //When
        Long idx1 = jetAuthTestHistoryService.save(jetAuthTestHistory1);

        //Then
        assertEquals(jetAuthTestHistory1, jetAuthTestHistoryService.findByIdx(idx1));

    }

    @Test
    public void 정보_리스트_테스트() {
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

        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                "TECHHIVE", "20210825_1", prevDateTime,
                123, 23, dateToday);
        JetAuthTestHistory jetAuthTestHistory2
                = createJetAuthTestHistory(
                "TECHHIVE", "20210825_1", nextDateTime,
                23, 53, dateToday);
        try{
            List<JetAuthTestHistory> resultList = jetAuthTestHistoryService.findAll();
            for (JetAuthTestHistory m : resultList) {
                System.out.println("m.getFacilityId() = " + m.getFacilityId());
                System.out.println("m.getNodeId() = " + m.getNodeId());
            }
        }
        catch (IllegalStateException e) {
            return;
        }
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

        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                "TECHHIVE", "20210825_1", prevDateTime,
                123, 23, dateToday);
        JetAuthTestHistory jetAuthTestHistory2
                = createJetAuthTestHistory(
                "TECHHIVE", "20210825_1", nextDateTime,
                23, 53, dateToday);

        try{
            List<JetAuthTestHistory> resultList = jetAuthTestHistoryService.findByUpdateNow(simpleDateFormat1.format(dateToday));
            for (JetAuthTestHistory m : resultList) {
                System.out.println("m.getFacilityId() = " + m.getFacilityId());
                System.out.println("m.getNodeId() = " + m.getNodeId());
            }
        }
        catch (IllegalStateException e) {
            e.printStackTrace();        }
    }

    public JetAuthTestHistory createJetAuthTestHistory(
            String facilityId,
            String nodeId,
            String presentationTime,
            Integer sensorPm10,
            Integer sensorPm25,
            Date createDttm)
    {
        JetAuthTestHistory jetAuthTestHistory = new JetAuthTestHistory();
        jetAuthTestHistory.setFacilityId(facilityId);
        jetAuthTestHistory.setNodeId(nodeId);
        jetAuthTestHistory.setPresentationTime(presentationTime);
        jetAuthTestHistory.setSensorPm10(sensorPm10);
        jetAuthTestHistory.setSensorPm25(sensorPm25);
        jetAuthTestHistory.setCreateDttm(createDttm);
        return jetAuthTestHistory;
    }
}
