package com.moitech.sensorinfo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="jet_auth_test5_history")
public class JetAuthTest5History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDX")
    private Long idx;

    @Column(name = "START_DTTM", columnDefinition = "DATETIME default null", nullable=true)
    private Date startDttm;

    @Column(name = "END_DTTM", columnDefinition = "DATETIME default null", nullable=true)
    private Date endDttm;

    @Column(name = "DELIVERY_TIME", columnDefinition="INT(11) default 10", nullable=true)
    private Integer deliveryTime;

    @Column(name = "CMD_YN", columnDefinition="CHAR(1) default Y", nullable=true)
    private String cmdYn;

    @Column(name = "CREATE_DTTM", columnDefinition = "DATETIME default CURRENT_TIMESTAMP", nullable=true)
    private Date createDttm;

    @Column(name = "UPDATE_DTTM", columnDefinition = "DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable=true)
    private Date updateDttm;
}
