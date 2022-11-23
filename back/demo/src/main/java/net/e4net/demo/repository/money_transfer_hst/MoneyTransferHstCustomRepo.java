package net.e4net.demo.repository.money_transfer_hst;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.MoneyTransferHst;

@Repository
public interface MoneyTransferHstCustomRepo {
    List<MoneyTransferHst> selectMoneyTransferHstByMemberSn(Long memberSn);
}
