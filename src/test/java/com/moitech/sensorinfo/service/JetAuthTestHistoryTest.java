package com.moitech.sensorinfo.service;

import com.moitech.sensorinfo.domain.JetAuthTestHistory;
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

public class JetAuthTestHistoryTest {
    @Autowired
    JetAuthTestHistoryService jetAuthTestHistoryService;
    @Autowired
    EntityManager em;

    @Test
    public void 정보_저장_테스트() {
        //Give
        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                        "12345", "01", "11:22:33",
                        123, 23, LocalDateTime.now());

        //When
        Long idx1 = jetAuthTestHistoryService.saveJetAuthtestHistory(jetAuthTestHistory1);

        //Then
        assertEquals(jetAuthTestHistory1, jetAuthTestHistoryService.findJetAuthTestHistoryByIdx(idx1));

    }

    @Test
    public void 정보_리스트_테스트() {
        //Given
        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                "12345", "01", "11:22:33",
                123, 23, LocalDateTime.now());
        JetAuthTestHistory jetAuthTestHistory2
                = createJetAuthTestHistory(
                "12345", "02", "11:22:43",
                23, 53, LocalDateTime.now());
        try{
            List<JetAuthTestHistory> resultList = jetAuthTestHistoryService.findJetAuthTestHistories();
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
        JetAuthTestHistory jetAuthTestHistory1
                = createJetAuthTestHistory(
                "12345", "01", "11:22:33",
                123, 23, LocalDateTime.now());
        JetAuthTestHistory jetAuthTestHistory2
                = createJetAuthTestHistory(
                "12345", "02", "11:22:43",
                23, 53, LocalDateTime.now());
        try{
            List<JetAuthTestHistory> resultList = jetAuthTestHistoryService.findJetAuthTestHistoriesByUpdateNow(LocalDateTime.now());
            for (JetAuthTestHistory m : resultList) {
                System.out.println("m.getFacilityId() = " + m.getFacilityId());
                System.out.println("m.getNodeId() = " + m.getNodeId());
            }
        }
        catch (IllegalStateException e) {
            return;
        }
    }

    public JetAuthTestHistory createJetAuthTestHistory(
            String facilityId,
            String nodeId,
            String presentationTime,
            Integer sensorPm10,
            Integer sensorPm25,
            LocalDateTime createDttm)
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
