package net.e4net.demo.repository.member;

import net.e4net.demo.repository.member.MemberCustomRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.TbMember;

@Repository
public interface MemberRepo extends JpaRepository<TbMember, Long>, MemberCustomRepo {
    TbMember findByMembId(String membId);
}
