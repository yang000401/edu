package net.e4net.demo.repository.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Long>, MerchantCustomRepo{

}
