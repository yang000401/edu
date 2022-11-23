package net.e4net.demo.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
//https://hianna.tistory.com/629
//Gson은 Java에서 Json을 파싱하고, 생성하기 위해 사용되는 구글에서 개발한 오픈소스입니다.
//Java Object를 Json 문자열로 변환할 수 있고, Json 문자열을 Java Object로 변환할 수 있습니다.

import lombok.extern.slf4j.Slf4j;
import net.e4net.demo.common.ApiCd;
import net.e4net.demo.common.RVO;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.debug("[CustomAccessDeniedHandler] {}, {}, {}", request, response, accessDeniedException);
        log.debug("[CustomAccessDeniedHandler] {}", request.getRequestURI());
        if(request.getRequestURI().startsWith("/api")) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json; charset=UTF-8");
            out.print(new Gson().toJson(RVO.builder().msg("인가에 실패 하였습니다.").data(accessDeniedException.getMessage()).code(ApiCd.NOT_AUTH).build()));
        } else {
            //response.sendRedirect("/public/login");
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, accessDeniedException.getMessage());
            response.sendRedirect("/public/denied");
        }
    }

}
