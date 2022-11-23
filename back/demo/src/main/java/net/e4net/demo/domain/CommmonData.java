package net.e4net.demo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

//@MappedSuperclass
//public abstract class CommmonData {
//    @Column(name = "USE_YN")
//    private String useYn;
//
//    @Column(name = "FRST_REGIST_MEMB_SN", length = 10, updatable = false, nullable =false )
//    private Long frsRegistMembSn;
//
//    @CreatedDate
//    @Column(name = "FRST_RESIT_DT", updatable = false, nullable = false)
//    private Timestamp frstRegistDt;
//
//    @Column(name = "LAST_RESIT_Sn", length = 10, updatable = true, nullable = true)
//    private long lastRegistSn;
//
//    @LastModifiedBy
//    @Column(name = "LAST_RESIT_DT", updatable = true, nullable = true)
//    private Timestamp lastRegistDt;
//
//    protected Base(Long frst)

//}
