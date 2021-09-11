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
@Table(name="jet_auth_test_history")
public class JetAuthTestHistory {
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

    @Column(name = "TSI_PM25", columnDefinition="INT(11) default 0", nullable=false)
    private Integer tsiPm25;

    @Column(name = "MOI_PM25", columnDefinition="INT(11) default 0", nullable=false)
    private Integer moiPm25;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DTTM", columnDefinition = "DATETIME default CURRENT_TIMESTAMP", nullable=false)
    private Date createDttm;
}
