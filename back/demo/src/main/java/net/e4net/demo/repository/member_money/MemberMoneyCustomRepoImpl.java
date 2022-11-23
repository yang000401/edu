package net.e4net.demo.repository.member_money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import net.e4net.demo.entity.MemberMoney;
import net.e4net.demo.entity.QMemberMoney;

@Repository
public class MemberMoneyCustomRepoImpl implements MemberMoneyCustomRepo{
    @Autowired private JPAQueryFactory qf;

    @Override
    public MemberMoney memberMoneyChkByMemberSn(Long memberSn) {
        QMemberMoney qmm = QMemberMoney.memberMoney;
        return qf.selectFrom(qmm).where(qmm.memberSn.eq(memberSn)).fetchOne();
    }
}

