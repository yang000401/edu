package net.e4net.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.e4net.demo.entity.TbMember;
import net.e4net.demo.repository.member.MemberRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired private MemberRepo memRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbMember member = memRepo.findByMembId(username);
        if(member == null) throw new UsernameNotFoundException("유저가 존재하지 않습니다.");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getMembCls().getCodeValue()));
        member.setAuthorities(authorities);
        return member;
    }
}
