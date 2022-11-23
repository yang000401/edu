package net.e4net.demo.restcontroller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.e4net.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.e4net.demo.common.ApiCd;

import net.e4net.demo.common.RVO;
import net.e4net.demo.dto.ChargeDto;
import net.e4net.demo.entity.TbMember;
import net.e4net.demo.service.UserService;

@Tag(name = "user-rest-controller", description = "USER 권한이 사용할수 있는 api")
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {
    @Autowired private UserService userService;

    @Operation(summary = "테스트", description = "테스트")
    @GetMapping("/test")
    public String test() {
        return "testUser";
    }

    //충전
    @Operation(summary = "머니충전", description = "해당 멤버의 머니를 충전한다., <br/> 결제수단> 카드: 01, 계좌: 02")
    @PostMapping("/charge")
    public RVO<MemberMoney> charge(
            @Parameter(hidden = true) @AuthenticationPrincipal TbMember tbMember,
            @RequestBody ChargeDto chargeDto) {
        return RVO.<MemberMoney>builder()
                .msg("충전이 완료되었습니다.")
                .code(ApiCd.NORMAL)
                .data(userService.charge(tbMember, chargeDto))
                .build();
    }

    //구매
    @Operation(summary = "구매", description = "해당 상품을 구매한다.")
    @PostMapping("/buy")
    public RVO<MoneyTransferHst> charge(
            @Parameter(hidden = true) @AuthenticationPrincipal MemberMoney membermoney,
            String goodsSn) {
        return RVO.<MoneyTransferHst>builder()
                .msg("구매가 완료되었습니다.")
                .code(ApiCd.NORMAL)
                .data(userService.buy(membermoney, goodsSn))
                .build();
    }


    //결제이력 보기
    @Operation(summary = "머니 결제 이력 보기", description = "머니 결제 이력 보기")
    @GetMapping("/moneyTransferHst")
    public RVO<List<MoneyTransferHst>> moneyTransferHst(
            @Parameter(hidden = true) @AuthenticationPrincipal MemberMoney membermoney){
        return RVO.<List<MoneyTransferHst>>builder()
                .msg("머니 결제 이력 입니다.")
                .code(ApiCd.NORMAL)
                .data(userService.getMoneyTransfHst(membermoney.getMemberSn()))
                .build();
    }

    @Operation(summary = "상품 전체 조회", description = "모든 상품을 조회 해온다.")
    @GetMapping("/goods")
    public RVO<List<Goods>> allGoods(){
        return RVO.<List<Goods>>builder()
                .msg("test")
                .code(ApiCd.NORMAL)
                .data(userService.allGoods())
                .build();

    }

    @Operation(summary = "가맹점 전체 조회", description = "모든 가맹점을 조회 해온다.")
    @GetMapping("/merchants")
    public RVO<List<Merchant>> allMerchants(){
        return RVO.<List<Merchant>>builder()
                .msg("test")
                .code(ApiCd.NORMAL)
                .data(userService.allMerchants())
                .build();
    }
}
