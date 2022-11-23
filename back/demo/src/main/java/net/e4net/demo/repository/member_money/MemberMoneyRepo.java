package net.e4net.demo.repository.member_money;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.TbMember;
import net.e4net.demo.entity.MemberMoney;

@Repository
public interface MemberMoneyRepo extends JpaRepository<MemberMoney, TbMember>, MemberMoneyCustomRepo{

}
