package net.e4net.demo.repository.buyhst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.BuyHst;

@Repository
public interface BuyHstRepo extends JpaRepository<BuyHst, Long>, BuyHstCustomRepo{

}
