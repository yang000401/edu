package net.e4net.demo.repository.member_login_hst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberLoginHstCustomRepoImpl implements MemberLoginHstCustomRepo{
    @Autowired private JPAQueryFactory qf;
}
