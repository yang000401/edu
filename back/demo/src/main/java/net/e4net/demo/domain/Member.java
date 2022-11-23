package net.e4net.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Getter
//@Entity
//@Table(name = "TB_MENB")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
//        initialValue = 1,
//        allocationSize = 1
//)
//public class Member extends CommmonData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
//    @Column(name = "MEMB_SN", length = 10)
//    private Long membSn;
//
//    @Column(name = "MEMB_CLS", length = 20)
//    private String membCls;
//
//    @OneToOne(mappedBy = "member", cascade = CascadeType.PERSIST)
//    private MembMoney membMoney;
//
//    @Builder
//    private Member(String membCls) {
//        super(1,2);
//        this.membCls = membCls;
//
//    }
//    public static Member createMember(String membCls) {
//        return Member.builder()
//                .membCls(membCls)
//                .build();
//    }
//
//    public void setMembMoney(MembMoney membMoney) {
//        this.membMoney = membMoney;
//    }
//}
