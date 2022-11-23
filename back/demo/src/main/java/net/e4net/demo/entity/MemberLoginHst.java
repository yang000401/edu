package net.e4net.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_memb_login_hst", indexes = @Index(columnList = "login_sn"))
@SequenceGenerator(name = "memLoginHst_seq", allocationSize = 1, initialValue = 1, sequenceName = "memLoginHst_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class MemberLoginHst extends Base{
    @Id@GeneratedValue(generator = "memLoginHst_seq", strategy = GenerationType.SEQUENCE)@Column(name = "login_sn")
    private Long loginSn;

    @ManyToOne //다대 일 관계라는 매핑정보
    @JoinColumn(name = "member_sn") //meber_sn이 기본키라 따로 onetomany를 안걸어 놓음
    private TbMember memberSn;

    @Column(name = "connect_ip")
    private String connectIp;
}
