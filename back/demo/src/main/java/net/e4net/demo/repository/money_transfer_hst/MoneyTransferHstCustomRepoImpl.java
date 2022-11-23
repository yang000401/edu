package net.e4net.demo.repository.money_transfer_hst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import net.e4net.demo.entity.MoneyTransferHst;
import net.e4net.demo.entity.QMoneyTransferHst;

@Repository
public class MoneyTransferHstCustomRepoImpl implements MoneyTransferHstCustomRepo{
    @Autowired private JPAQueryFactory qf;

    @Override
    public List<MoneyTransferHst> selectMoneyTransferHstByMemberSn(Long memberSn) {
        QMoneyTransferHst qmth = QMoneyTransferHst.moneyTransferHst;
        return qf.selectFrom(qmth).where(qmth.useYn.eq("Y").and(qmth.memberSn.memberSn.eq(memberSn))).fetch();
    }
}
