package net.e4net.demo.restcontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.e4net.demo.common.ApiCd;
import net.e4net.demo.common.RVO;
import net.e4net.demo.dto.JoinDto;
import net.e4net.demo.entity.TbMember;
import net.e4net.demo.entity.MemberMoney;
import net.e4net.demo.service.AuthService;
//포스트맨 테스트
@Tag(name = "auth-rest-controler", description = "인증관련 restController")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {
    @Autowired private AuthService authService;

    @Operation(summary = "토큰발급", description = "id, pw 체크후 해당 유저의 토큰을 생성해 줍니다.")//토큰 발행 조회
    @GetMapping("/token")
    public RVO<String> token(HttpServletRequest request, String id, String pw){
        return RVO.<String>builder()
                .msg("JWT 토큰이 생성되었습니다.")
                .code(ApiCd.NORMAL)
                .data(authService.gettoken(id, pw, request.getRemoteAddr()))
                .build();
    }

    @Operation(summary = "판매자 가입", description = "권한이 판매자로 가입 됩니다.")
    @PostMapping("/sellerJoin")
    public RVO<TbMember> sellerJoin(@RequestBody JoinDto joinDto){
        return RVO.<TbMember>builder()
                .msg("판매자 가입 되었습니다.")
                .code(ApiCd.NORMAL)
                .data(authService.sellerJoin(joinDto))
                .build();
    }

    @Operation(summary = "사용자 가입", description = "권한이 사용자로 가입 됩니다.")
    @PostMapping("/userJoin")
    public RVO<MemberMoney> userJoin(@RequestBody JoinDto joinDto){
        return RVO.<MemberMoney>builder()
                .msg("사용자 가입 되었습니다.")
                .code(ApiCd.NORMAL)
                .data((MemberMoney) authService.userJoin(joinDto))
                .build();
    }

    @Operation(summary = "탈퇴", description = "해당 멤버의 상태가 탈퇴로 꺽입니다.")
    @PostMapping("/resign")
    public RVO<TbMember> resign(){
        return RVO.<TbMember>builder()
                .msg("탈퇴에 성공하였습니다.")
                .code(ApiCd.NORMAL)
                .data(authService.resign())
                .build();
    }

}
