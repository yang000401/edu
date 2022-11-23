package net.e4net.demo.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import net.e4net.demo.common.ApiCd;
import net.e4net.demo.common.RVO;

@Slf4j
@Configuration
public class AuthEntryPoint_DENIED implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        Object exType = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        log.debug("[JwtAuthenticationEntryPoint]! err: {}, {}, {}", authException.getMessage(), request.getRequestURI(), exType);
        if(request.getRequestURI().startsWith("/api")) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json; charset=UTF-8");
            out.print(new Gson().toJson(RVO.builder().msg("인증에 실패 하였습니다.").data(authException.getMessage()).code(ApiCd.NOT_AUTH).build()));
        } else {
            response.sendRedirect("/public/login");
        }
    }
}
