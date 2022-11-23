package net.e4net.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import net.e4net.demo.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.e4net.demo.common.Cd;
import net.e4net.demo.dto.ChargeDto;
import net.e4net.demo.entity.BuyHst;
import net.e4net.demo.entity.Goods;
import net.e4net.demo.entity.TbMember;
import net.e4net.demo.entity.MemberMoney;
import net.e4net.demo.entity.Merchant;
import net.e4net.demo.entity.MoneyTransferHst;
import net.e4net.demo.repository.buyhst.BuyHstRepo;
import net.e4net.demo.repository.goods.GoodsRepo;
import net.e4net.demo.repository.member_money.MemberMoneyRepo;
import net.e4net.demo.repository.merchant.MerchantRepo;
import net.e4net.demo.repository.money_transfer_hst.MoneyTransferHstRepo;

@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired private MemberMoneyRepo mmRepo;
    @Autowired private BuyHstRepo buyHstRepo;
    @Autowired private MerchantRepo merchantRepo;
    @Autowired private GoodsRepo goodsRepo;
    @Autowired private MoneyTransferHstRepo moneyTrfHstRepo;

    @Autowired private EntityUtil eu;

    //충전
    public MemberMoney charge(TbMember member, ChargeDto chargeDto) {
        MemberMoney mem = mmRepo.memberMoneyChkByMemberSn(member.getMemberSn());
        MoneyTransferHst mtf = new MoneyTransferHst();
        //충전
        mtf.setTransferTyCd(eu.getMoneyTransferCmm(Cd.MONEY_TSF_TY_CHARGE));
        //충전방식은 dto에서
        mtf.setPayMeanCd(eu.getMoneyMeanCmm(chargeDto.getChargeMean()));
        mtf.setMemberSn(mem);
        mtf.setTransferAmt(chargeDto.getChargeAmt());
        moneyTrfHstRepo.save(mtf);
        mem.setMoneyBlce(mem.getMoneyBlce() + chargeDto.getChargeAmt());
        return mmRepo.save(mem);
    }
    //구매
    public MoneyTransferHst buy(MemberMoney memberMoney, String goodsSn) {
        //1. 해당 상품의 구매 가능여부 체크
        //2. 현재 사용자의 머니 잔액으로 해당 상품을 구매할수 있는지 체크
        //3. 해당 상품의 남은 수량 -1, 판매수량 +1
        //4. 사용자의 머니 잔액을 상품의 금액만큼 차감
        //5. 상품 구매 이력 인서트 한다.
        //6. 머니 거래이력에 거래종류는 사용, 결제수단은 머니사용으로 한다.
        Goods goods = goodsRepo.selectValidateGoods(goodsSn);
        if(goods == null) throw new RuntimeException("존재하지 않는 상품 입니다.");
        String goodsClsDtStr = goods.getGoodsClsDt();
        Date goodsClsDate = null;
        try {
            goodsClsDate = new SimpleDateFormat("yyyyMMdd").parse(goodsClsDtStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("상품 마감 일자가 올바르지 않습니다.");
        }
        Date nowDate = new Date();
        if(nowDate.after(goodsClsDate)) throw new RuntimeException("판매 종료된 상품 입니다.");
        if(goods.getGoodsQtt() < 1) throw new RuntimeException("없는 상품 입니다.");

        Long goodsAmtWithShppCost = goods.getGoodsAmt() + goods.getGoodsShppCost();
        Long goodsAmt = goods.getGoodsAmt();

        if(memberMoney.getMoneyBlce() < goodsAmtWithShppCost) throw new RuntimeException("머니가 부족합니다.");

        goods.setGoodsQtt(goods.getGoodsQtt() - 1);
        goods.setGoodsSellQtt(goods.getGoodsSellQtt() + 1);
        goodsRepo.save(goods);

        memberMoney.setMoneyBlce(memberMoney.getMoneyBlce()-goodsAmtWithShppCost);
        mmRepo.save(memberMoney);

        BuyHst buyHst = new BuyHst();
        buyHst.setBuyAmt(goodsAmtWithShppCost);
        buyHst.setGoodsAmt(goodsAmt);
        buyHst.setGoodsSn(goods);
        buyHst.setMemberSn(memberMoney);
        buyHstRepo.save(buyHst);

        MoneyTransferHst moneyTransferHst = new MoneyTransferHst();
        moneyTransferHst.setBuyHst(buyHst);
        moneyTransferHst.setMemberSn(memberMoney);
        moneyTransferHst.setPayMeanCd(eu.getMoneyMeanCmm(Cd.MONEY_MEAN_MONEY));
        moneyTransferHst.setTransferTyCd(eu.getMoneyTransferCmm(Cd.MONEY_TSF_TY_USE));
        moneyTransferHst.setTransferAmt(goodsAmtWithShppCost);
        return moneyTrfHstRepo.save(moneyTransferHst);
    }
    //머니 결제 이력
    public List<MoneyTransferHst> getMoneyTransfHst(Long memberSn){
        return moneyTrfHstRepo.selectMoneyTransferHstByMemberSn(memberSn);
    }

    //모든 가맹점 조회
    public List<Merchant> allMerchants(){
        return merchantRepo.selectAllMerchant();
    }

    //모든 상품 조회
    public List<Goods> allGoods(){
        return goodsRepo.selectAllGoods();
    }
}
