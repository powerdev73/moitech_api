package com.moitech.sensorinfo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="jet_auth_test2_history")

public class JetAuthTest2History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDX")
    private Long idx;

    @Column(name = "FACILITY_ID", length=50, nullable=false)
    private String facilityId;

    @Column(name = "NODE_ID", length=50, nullable=false)
    private String nodeId;

    @Column(name = "PRESENTATION_TIME", length=50, nullable=false)
    private String presentationTime;

    @Column(name = "TSI1_PM10", columnDefinition="INT(11) default 0", nullable=false)
    private Integer tsi1Pm10;

    @Column(name = "TSI2_PM25", columnDefinition="INT(11) default 0", nullable=false)
    private Integer tsi2Pm25;

    @CreationTimestamp // 생성 시간 자동 입력
    @Column(name = "CREATE_DTTM", columnDefinition = "DATETIME default CURRENT_TIMESTAMP", nullable=false)
    private Date createDttm;
}
