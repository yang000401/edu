package net.e4net.demo.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Setter // lombok
@Getter  //lombok
@NoArgsConstructor //lombok 관련 https://www.daleseo.com/lombok-popular-annotations/
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base extends BaseTime {
    @CreatedBy
    @Column(name = "frst_regist_memb_sn")
    private Long frstRegistMemberSn;

    @LastModifiedBy
    @Column(name = "last_change_memb_sn")
    private Long lastChangeMemberSn;
}

