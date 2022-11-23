package net.e4net.demo.repository.member_money;

import org.springframework.stereotype.Repository;
import net.e4net.demo.entity.MemberMoney;

@Repository
public interface MemberMoneyCustomRepo {
    MemberMoney memberMoneyChkByMemberSn(Long memberSn);
}

