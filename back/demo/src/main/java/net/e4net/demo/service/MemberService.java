//package net.e4net.demo.service;
//
//import lombok.RequiredArgsConstructor;
//import net.e4net.demo.domain.MembMoney;
//import net.e4net.demo.domain.Member;
//import net.e4net.demo.repository.MemberRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class MemberService {
//    private final MemberRepository memberRepository;
//
//    @Transactional
//    public void join(Member member) {
//        MembMoney.createMembMoney(memberRepository.save(Member.createMember("Role_admin")));
//    }
//
//
//}
