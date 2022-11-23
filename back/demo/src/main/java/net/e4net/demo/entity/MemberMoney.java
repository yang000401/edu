package net.e4net.demo.entity;
import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable; //테이블 상속

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_memb_money")
//@SequenceGenerator(name = "memLoginHst_seq", allocationSize = 1, initialValue = 1, sequenceName = "memLoginHst_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
@DiscriminatorValue("member_money")
public class MemberMoney extends TbMember{
    private static final long serialVersionUID = 1L;
    @Column(name = "money_blce", length = 15)
    @ColumnDefault("0")
    private Long moneyBlce;
}

//@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
//@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
//@Getter
//@Setter
//@Table(name = "tb_memb_money")
////@SequenceGenerator(name = "memLoginHst_seq", allocationSize = 1, initialValue = 1, sequenceName = "memLoginHst_seq")
//@DynamicInsert
//@DynamicUpdate
//@EntityListeners(AuditingEntityListener.class)
//@Entity
//@DiscriminatorValue("member_money")
//public class MemberMoney extends Base implements Serializable //https://dkfkslsksh.tistory.com/64
//{
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "memberSn")
//    private TbMember memberSn;
//    private static final long serialVersionUID = 1L;
//    @Column(name = "money_blce", length = 15)
//    @ColumnDefault("0")
//    private Long moneyBlce;
//}

// @Entity
//@Getter
//@Setter
//@Data
//@Table(name = "MEMB_MONEY")
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
//
//    @Id
//    @OneToManey(mappedBy = "membSn")
//    List<MembSn> membSn2 = new ArrayList<MembSn>(); -> 컨테이너 에러가 남 @Id를 지우니 에러는 해결 근데 기본키가 없어서 에러
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
// 예전에 시도한 것도 Serializable와 함께 다시 시도하면 결과가 바뀌려나