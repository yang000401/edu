package net.e4net.demo.repository.merchant;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.Merchant;

@Repository
public interface MerchantCustomRepo {
    List<Merchant> selectAllMerchant();
}
