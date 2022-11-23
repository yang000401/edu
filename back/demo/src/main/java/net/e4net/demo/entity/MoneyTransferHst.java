package net.e4net.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.Member;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_money_transfer_hst")
//, indexes = @Index(columnList = "login_sn")
@SequenceGenerator(name = "money_transfer_hst_seq", allocationSize = 1, initialValue = 1, sequenceName = "money_transfer_hst_seq")
@DynamicInsert
@DynamicUpdate

@EntityListeners(AuditingEntityListener.class)
@Entity
public class MoneyTransferHst extends Base {
    @Id@GeneratedValue(generator = "money_transfer_hst_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "money_transfer_hst_sn")
    private long moneytransferhstSn;

    @ManyToOne
    @JoinColumn(name = "member_sn")
    private TbMember memberSn;

    @OneToOne
    @JoinColumn(name = "transfer_ty_cd")
    private CmmnCodeDetail transferTyCd;

    @OneToOne
    @JoinColumn(name = "buy_hst_sn")
    private BuyHst buyHst;

    @Column(name = "transfer_amt", length = 15, nullable = false)
    private Long transferAmt;

    @OneToOne
    @JoinColumn(name = "pay_mean_cd")
    private CmmnCodeDetail payMeanCd;

    @Column(name = "pay_transfer_no", length = 20)
    private String payTransferNo;



}
