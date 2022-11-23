package net.e4net.demo.repository.cmmn_code_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class CmmnCodeDetailCustomRepoImpl implements CmmnCodeDetailCustomRepo{
    @Autowired private JPAQueryFactory qf;
}
