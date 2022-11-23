package net.e4net.demo.repository.member_login_hst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.MemberLoginHst;

@Repository
public interface MemberLoginHstRepo extends JpaRepository<MemberLoginHst, Long>, MemberLoginHstCustomRepo{

}
