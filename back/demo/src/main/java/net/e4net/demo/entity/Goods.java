package net.e4net.demo.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_goods", indexes = @Index(columnList = "goods_sn"))
//@SequenceGenerator(name = "goods_seq", allocationSize = 1, initialValue = 1, sequenceName = "goods_seq")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Goods extends Base{
    //상품번호
    @Id
    @GeneratedValue(generator = "goods_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "goods_sn", length = 15)
    private String goodsSn;

    //가맹점 정보
    @ManyToOne //다대일 관계 하나의 굿즈 여러개가 가맹점 한개에 들어감
    @JoinColumn(name = "merchant_sn")
    //의문이 생긴 이유 ▼ 해설은 필드명 아래 참고
    //@JoinColumn(name = "merchant_sn") 생략해도 실행됨
    //https://hyeon9mak.github.io/omit-join-colum                                                                n-when-using-many-to-one/
    //@JoinColumn: 조인 컬럼은 외래 키를 매핑할 때 사용한다. name 속성에는 매핑할 외래 키 이름을 지정한다.
    // 회원과 팀 테이블은 TEAM_ID 외래 키로 연관관계를 맺으므로 이 값을 지정하면 된다. 이 어노테이션은 생략할 수 있다.
    //중간 테이블을 만들거 같다는 예상과는 다르게,
    // @JoinColumn 어노테이션을 사용할 때와 완전히 동일하게 동작하고 있다. 김영한님이 책에서 말씀하신대로 생략이 가능했다.
    // @JoinColumn은 엔티티간 조인과는 관계없이 외래키 이름 지정을 위해서만 사용하는 것이었고, 생략이 될 경우 알아서
    // @ManyToOne의 대상이 되는 엔티티의 이름_id를 대상으로 삼는 것 같았다.
    private Merchant merchantSn;

    //             @JoinColumn(name = "merchant_sn")이 없을때
    //        goods_shpp_cost int8,
    //        real_file_nm varchar(100),
    //        merchant_sn_merchant_sn int8, -> 기본전략을 사용
    //        primary key (goods_sn)
    //    ) 기본전략을 사용

    //             @JoinColumn(name = "merchant_sn")이 있을때
    //        goods_shpp_cost int8,
    //        real_file_nm varchar(100),
    //        merchant_sn int8,
    //        primary key (goods_sn)
    //    )

    // @JoinColumn은 외래키를 매핑할 때 사용한다
    // @JoinColumn을 생략하면 외래키를 찾을 때 기본 전략을 사용한다
    // 기본전략: 필드명+_+참조하는 테이블의 컬럼명
    //예시: 필드명(merchantSn) + _ + 참조하는 테이블의 컬럼명(merchant_sn) = merchantSn_merchant_sn 외래키를 사용한다
    //참고 ->  @Column(name = "merchant_sn") 필드명과 컬럼명을 통일해 놔서 구분이 안갈 수 있는데 컬럼같은 경우 모두 소문자이다
    //         private Long merchantSn;



    //상품명
    @NotNull
    @Column(name = "goods_nm", length = 200, nullable = false)
    private String goodsNm;

    //상품명

    @Column(name = "goods_model_no", length = 30, nullable = false)
    private String goodsModelNo;

    //상품금액
    @Column(name = "goods_amt", length = 15)
    private Long goodsAmt;

    //상품수량
    @Column(name = "goods_qtt", length = 8)
    private Long goodsQtt;

    //판매수량
    @Column(name = "goods_sell_qtt", length = 8)
    private Long goodsSellQtt;

    //판매종료일자
    @Column(name = "goods_cls_dt", length = 8)
    private String goodsClsDt;

    //배송비용
    @Column(name = "goods_shpp_cost", length = 6)
    private Long goodsShppCost;

    //실제파일명
    @Column(name = "real_file_nm", length = 100)
    private String realFileNm;

    //상품이미지경로
    @Column(name = "goods_img_path", length = 200)
    private String goodsImgPath;

    //상품설명
    @Column(name = "goods_desc", length = 4000)
    private String goodsDesc;
}
