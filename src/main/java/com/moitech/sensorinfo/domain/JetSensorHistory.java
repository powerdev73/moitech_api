package com.moitech.sensorinfo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="jet_sensor_history")
public class JetSensorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDX")
    private Long idx;

    @Column(name = "NODE_ID", length=50, nullable=false)
    private String nodeId;

    @Column(name = "FACILITY_ID", length=50, nullable=false)
    private String facilityId;

    @Column(name = "PRESENTATION_TIME", length=50, nullable=false)
    private String presentationTime;

    @Column(name = "SENSOR_PM10", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorPm10;

    @Column(name = "SENSOR_PM25", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorPm25;

    @Column(name = "SENSOR_CO2", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorCo2;

    @Column(name = "SENSOR_TEMP", columnDefinition="FLOAT(10,1) default 0.0", nullable=false)
    private Float sensorTemp;

    @Column(name = "SENSOR_HUMI", columnDefinition="FLOAT(10,1) default 0.0", nullable=false)
    private Float sensorHumi;

    @Column(name = "SENSOR_CH20", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorCh20;

    @Column(name = "SENSOR_CO", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorCo;

    @Column(name = "SENSOR_NO2", columnDefinition="INT(11) default 0", nullable=false)
    private Integer sensorNo2;

    @Column(name = "SENSOR_03", columnDefinition="FLOAT(10,1) default 0.0", nullable=false)
    private Float sensor03;

    @Column(name = "SENSOR_DIFF_PRESSURE", columnDefinition="FLOAT(10,1) default 0.0", nullable=false)
    private Float sensorDiffPressure;

    @CreationTimestamp // 생성 시간 자동 입력
    @Column(name = "CREATE_DTTM", columnDefinition = "DATETIME default CURRENT_TIMESTAMP", nullable=false)
    private Date createDttm;
}
