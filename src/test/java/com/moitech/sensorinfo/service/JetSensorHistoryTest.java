package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetSensorHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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

public class JetSensorHistoryTest {
    @Autowired
    JetSensorHistoryService jetSensorHistoryService;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(true)
    public void 정보_저장_테스트() {
        //Give
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss:SSS");
        String nowDateTime = simpleDateFormat.format(new Date());

        JetSensorHistory jetSensorHistory1
                = createSensorHistory("TECHHIVE","20210825_1",nowDateTime,13,
                12,591,19.6F,64.0F,0,0,0,
                0.0F,0.0F, new Date());

        //When
        Long idx1 = jetSensorHistoryService.save(jetSensorHistory1);

        //Then
        assertEquals(jetSensorHistory1, jetSensorHistoryService.findByIdx(idx1));
    }

    @Test
    @Rollback(true)
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

        JetSensorHistory jetSensorHistory1
                = createSensorHistory("TECHHIVE","20210825_1",prevDateTime,13,
                12,591,19.6F,64.0F,0,0,0,
                0.0F,0.0F, dateToday);
        JetSensorHistory jetSensorHistory2
                = createSensorHistory("TECHHIVE","20210825_1",nextDateTime,14,
                13,690,19.6F,64.0F,0,0,0,
                0.0F,0.0F, dateToday);

        try{
            List<JetSensorHistory> resultList = jetSensorHistoryService.findAll();
            for (JetSensorHistory m : resultList) {
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

        JetSensorHistory jetSensorHistory1
                = createSensorHistory("TECHHIVE","20210825_1",prevDateTime,13,
                12,591,19.6F,64.0F,0,0,0,
                0.0F,0.0F, dateToday);
        JetSensorHistory jetSensorHistory2
                = createSensorHistory("TECHHIVE","20210825_1",nextDateTime,14,
                13,690,19.6F,64.0F,0,0,0,
                0.0F,0.0F, dateToday);

        try {
            List<JetSensorHistory> resultList = jetSensorHistoryService.findByUpdateNow(simpleDateFormat1.format(dateToday));
            for (JetSensorHistory m : resultList) {
                System.out.println("m.getFacilityId() = " + m.getFacilityId());
                System.out.println("m.getNodeId() = " + m.getNodeId());
            }
        } catch (Exception ex) {

        }
    }

    // 테스트용 데이터 입력
    private JetSensorHistory createSensorHistory(
            String facilityId,
            String nodeId,
            String presentationTime,
            Integer sensorPm10,
            Integer sensorPm25,
            Integer sensorCo2,
            Float sensorTemp,
            Float sensorHumi,
            int sensorCh20,
            int sensorCo,
            int sensorNo2,
            float sensor03,
            float sensorDiffPressure,
            Date nowDateTime)
    {
        JetSensorHistory jetSensorHistory = new JetSensorHistory();
        jetSensorHistory.setFacilityId(facilityId);
        jetSensorHistory.setNodeId(nodeId);
        jetSensorHistory.setPresentationTime(presentationTime);
        jetSensorHistory.setSensorPm10(0);
        jetSensorHistory.setSensorPm10(sensorPm10);
        jetSensorHistory.setSensorPm25(sensorPm25);
        jetSensorHistory.setSensorCo2(sensorCo2);
        jetSensorHistory.setSensorTemp(sensorTemp);
        jetSensorHistory.setSensorHumi(sensorHumi);
        jetSensorHistory.setSensorCh20(sensorCh20);
        jetSensorHistory.setSensorCo(sensorCo);
        jetSensorHistory.setSensorNo2(sensorNo2);
        jetSensorHistory.setSensor03(sensor03);
        jetSensorHistory.setSensorDiffPressure(sensorDiffPressure);
        jetSensorHistory.setCreateDttm(nowDateTime);
        return jetSensorHistory;
    }
}
