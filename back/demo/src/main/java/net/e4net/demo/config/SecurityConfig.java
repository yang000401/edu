package net.e4net.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.e4net.demo.security.JwtAuthenticationFilter;
import net.e4net.demo.security.AuthEntryPoint_DENIED;
import net.e4net.demo.security.CustomAccessDeniedHandler;
import net.e4net.demo.security.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    //공식 홈페이지를 보면, spring security 5.7이상에서 더 이상 WebSecurityConfigurerAdapter 사용을 권장하지 않는다고 한다.
    // WebSecurityConfigurerAdapter가 더이상 사용되지 않음, 버전에 따른 유통기한 있음, 검사 억제로 넘김




    @Autowired private AuthEntryPoint_DENIED aep;
    @Autowired private JwtAuthenticationFilter jwtFilter;
    @Autowired private CustomAccessDeniedHandler cad;
    @Autowired private CustomAuthenticationProvider cap;

    @Bean
    public PasswordEncoder pe() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/**", "/error/**", "/webjars/**", "/files/**", "/swagger-ui/**", "/v3/api-docs/**", "/favicon*", "/WEB-INF/views/error/errorPage.jsp");

        //spring security 제외 경로설정
        web.ignoring().antMatchers("/resources/**").antMatchers("/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(cap);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(aep)
                .accessDeniedHandler(cad)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/api/*/samp/**", "/api/*/auth/**").permitAll()
                .antMatchers("/api/*/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/*/seller/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_SELLER")
                .antMatchers("/api/*/user/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_SELLER", "ROLE_USER")
                .antMatchers("/public/**", "/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/public/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/public/login")
                .invalidateHttpSession(true);
    }
}

