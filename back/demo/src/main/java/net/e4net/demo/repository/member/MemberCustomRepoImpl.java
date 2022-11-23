package net.e4net.demo.repository.member;

import net.e4net.demo.repository.member.MemberCustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import net.e4net.demo.entity.TbMember;
import net.e4net.demo.entity.QTbMember;
//커스텀 인터페이스를 구현하는 클래스에 QueryDSL 쿼리를 작성합니다.
//이 때, 해당 구현 클래스 이름은 반드시 Impl로 끝나야 합니다.
@Repository
public class MemberCustomRepoImpl implements MemberCustomRepo {
    @Autowired private JPAQueryFactory qf;

    @Override
    public TbMember memberChkById(String id) {
        QTbMember qmem = QTbMember.tbMember;
        return qf.selectFrom(qmem).where(qmem.membId.eq(id).and(qmem.useYn.eq("Y"))).fetchOne();
    }
}
