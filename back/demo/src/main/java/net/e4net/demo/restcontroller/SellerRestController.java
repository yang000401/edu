package net.e4net.demo.restcontroller;

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
import net.e4net.demo.dto.GoodsInsertDto;
import net.e4net.demo.dto.MerchantInsertDto;
import net.e4net.demo.entity.Goods;
import net.e4net.demo.entity.Merchant;
import net.e4net.demo.service.SellerService;
@Tag(name = "seller-rest-controller", description = "SELLER 권한이 사용할수 있는 api")
@RestController
@RequestMapping("/api/v1/seller")
public class SellerRestController {
    @Autowired private SellerService sellerService;

    @Operation(summary = "테스트", description = "테스트")
    @GetMapping("/test")
    public String test() {
        return "testSeller";
    }
    //가맹점등록
    @Operation(summary = "가맹점등록", description = "가맹점등록")
    @PostMapping("/merchant")
    public RVO<Merchant> insertMerchant(@RequestBody MerchantInsertDto mDto) {
        return RVO.<Merchant>builder()
                .code(ApiCd.NORMAL)
                .msg("가맹점 등록이 완료되었습니다.")
                .data(sellerService.insertMerchang(mDto))
                .build();
    }

    //상품등록
    @Operation(summary = "상품등록", description = "상품등록")
    @PostMapping("/goods")
    public RVO<Goods> insertGoods(@RequestBody GoodsInsertDto gDto){
        return RVO.<Goods>builder()
                .code(ApiCd.NORMAL)
                .msg("상품등록이 완료되었습니다.")
                .data(sellerService.insertGoods(gDto))
                .build();
    }
}
