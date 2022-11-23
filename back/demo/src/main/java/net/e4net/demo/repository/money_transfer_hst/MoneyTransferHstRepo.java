package net.e4net.demo.repository.money_transfer_hst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.MoneyTransferHst;

@Repository
public interface MoneyTransferHstRepo extends JpaRepository<MoneyTransferHst, Long>, MoneyTransferHstCustomRepo{

}
