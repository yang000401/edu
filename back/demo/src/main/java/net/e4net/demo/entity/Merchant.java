package net.e4net.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;
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
@Table(name = "tb_merchant", indexes = @Index(columnList = "merchant_sn"))
@SequenceGenerator(name = "merchant_seq", allocationSize = 1, initialValue = 1, sequenceName = "merchant_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Merchant extends Base {
    @Id
    @GeneratedValue(generator = "merchant_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "merchant_sn")
    private Long merchantSn;

//    @OneToMany(mappedBy = "TbMember")
//    private List<TbMember> memberSn;

    //자바 코드상의 에러는 없음 빌드오류 아마 joincolumn을 merchantsn에 안해서 그런듯
    //2022-11-10 11:14:58.935 ERROR 11368 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: mappedBy reference an unknown target entity property: net.e4net.demo.entity.TbMember.TbMember in net.e4net.demo.entity.Merchant.memberSn
    //양방향 연관관계 test
    // https://programmingrecoding.tistory.com/62
    //양방향 관계를 하면 조회의 간편함이 있다
    //객체의 양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개이다.
    // 객체를 양방향으로 참조하려면 위의 사진처럼 단방향인 연관관계를 2개 만들어야 하는 것이다.
    //반면에 테이블을 생각해보면 테이블은 외래키 하나로 두개의 테이블의 연관관계를 관리할 수 있다. MEMBER.TEAM_ID = memberSn(?)  외래키 하나로 양방향 연관관계를 가지게 되는것이다.
    //그렇다면 결국, 객체는 Team team든지 List members 든지, 둘중에 하나로 외래 키를 관리해야하는 것이다.
    //그래서 가장 중요한 것이 바로 연관관계의 주인(Owner)를 정하는 것이다

    @JoinColumn(name = "member_sn")
    @OneToOne
    private TbMember memberSn;
    //https://ict-nroo.tistory.com/126
    //OneToOne


    //https://kok202.tistory.com/138
    //두 객체 간에는 mapped by 에의한 어떤 관계인지 명시되지 않았다.
    // 이 때 Team은 Member 리스트를 가지고 있고 Member는 Team을 가지고 있지만 두 객체는 양방향 관계가 아니다.
    // 본질적으로 @OneToMany와 @ManyToOne과 같은 어노테이션은 하나의 단방향 관계를 표현하기 위한 어노테이션이다.  즉 두개의 단방향 관계가 있을 뿐이다.

//    @OneToMany(mappedBy="TbMember")
//   private TbMember memberSn; 대놓고 실수한 것 같기도함
//   'One To Many' attribute type should be a container

    @NotNull
    @Column(name = "merchant_nm", length = 100, nullable = false)
    private String merchantNm;

    @Column(name = "merchant_desc", length = 400)
    private String merchantDesc;

    @Column(name = "merchant_url", length = 100)
    private String merchantUrl;

    @Column(name = "tel_no", length = 20)
    private String telNo;

    @Column(name = "email_addr", length = 100)
    private String EmailAddr;

    @Column(name = "zip_cd", length = 6)
    private String zipCd;

    @Column(name = "zip_addr", length = 150)
    private String zipAddr;

    @Column(name = "detail_addr", length = 150)
    private String detailAddr;
}
