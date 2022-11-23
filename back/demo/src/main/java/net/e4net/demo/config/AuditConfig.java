package net.e4net.demo.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import net.e4net.demo.entity.TbMember;
@Component
public class AuditConfig implements AuditorAware<Long>{

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || ! auth.isAuthenticated()) return null;
        if("anonymousUser".equals(auth.getPrincipal())) return null;
        TbMember mem = (TbMember) auth.getPrincipal();
        String sn = String.valueOf(mem.getMemberSn());
        return Optional.of(Long.parseLong(sn));
    }

}
