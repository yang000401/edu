package net.e4net.demo.repository.buyhst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BuyHstCustomRepoImpl implements BuyHstCustomRepo{
    @Autowired private JPAQueryFactory qf;
}
