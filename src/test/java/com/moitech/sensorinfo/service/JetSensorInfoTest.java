package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetSensorInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JetSensorInfoTest {
    @Autowired
    JetSensorInfoService jetSensorInfoService;
    @Autowired
    EntityManager em;

    @Test
    public void 정보_저장_테스트() {
        //given
        JetSensorInfo jetSensorInfo1
                = createSensorHistory("1","1","127",1,
                1,1,1.1F,1.2F,3,2,1,
                3.8F,2.5F, LocalDateTime.now());
        //when
        String nodeId1 = jetSensorInfoService.saveJetSensorInfo(jetSensorInfo1);

        //then
        em.flush();
        assertEquals(jetSensorInfo1, jetSensorInfoService.findByNodeId(nodeId1));
    }

    @Test
    public void 현재_정보_가져오기_테스트(){
        //Given
        JetSensorInfo jetSensorInfo1
                = createSensorHistory("123","01","127",1,
                1,1,1.1F,1.2F,3,2,1,
                3.8F,2.5F, LocalDateTime.now());

        jetSensorInfoService.saveJetSensorInfo(jetSensorInfo1);

        //When
        JetSensorInfo jetSensorInfo_current = jetSensorInfoService.findByNodeId("01");
        System.out.println("jetSensorInfo1.getNodeId()) : "+ jetSensorInfo1.getNodeId());


    }

    // 테스트용 데이터 입력
    private JetSensorInfo createSensorHistory(
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
            LocalDateTime createDttm)
    {
        JetSensorInfo jetSensorInfo = new JetSensorInfo();
        jetSensorInfo.setFacilityId(facilityId);
        jetSensorInfo.setNodeId(nodeId);
        jetSensorInfo.setPresentationTime(presentationTime);
        jetSensorInfo.setSensorPm10(0);
        jetSensorInfo.setSensorPm10(sensorPm10);
        jetSensorInfo.setSensorPm25(sensorPm25);
        jetSensorInfo.setSensorCo2(sensorCo2);
        jetSensorInfo.setSensorTemp(sensorTemp);
        jetSensorInfo.setSensorHumi(sensorHumi);
        jetSensorInfo.setSensorCh20(sensorCh20);
        jetSensorInfo.setSensorCo(sensorCo);
        jetSensorInfo.setSensorNo2(sensorNo2);
        jetSensorInfo.setSensor03(sensor03);
        jetSensorInfo.setSensorDiffPressure(sensorDiffPressure);
        jetSensorInfo.setCreateDttm(createDttm);

        return jetSensorInfo;
    }
}
