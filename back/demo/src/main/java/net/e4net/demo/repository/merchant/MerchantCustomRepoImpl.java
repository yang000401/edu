package net.e4net.demo.repository.merchant;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import net.e4net.demo.entity.Merchant;
import net.e4net.demo.entity.QMerchant;

@Repository
public class MerchantCustomRepoImpl implements MerchantCustomRepo{
    @Autowired private JPAQueryFactory qf;

    @Override
    public List<Merchant> selectAllMerchant() {
        QMerchant qmerchant = QMerchant.merchant;
        return qf.selectFrom(qmerchant).fetch();
    }
}
