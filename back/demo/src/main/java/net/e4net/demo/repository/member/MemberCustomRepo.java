package net.e4net.demo.repository.member;

import net.e4net.demo.entity.TbMember;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCustomRepo {
    TbMember memberChkById(String id);
}
