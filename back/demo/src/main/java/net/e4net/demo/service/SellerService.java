package net.e4net.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.extern.slf4j.Slf4j;
import net.e4net.demo.dto.GoodsInsertDto;
import net.e4net.demo.dto.MerchantInsertDto;
import net.e4net.demo.entity.Goods;
import net.e4net.demo.entity.TbMember;
import net.e4net.demo.entity.Merchant;
import net.e4net.demo.entity.QGoods;
import net.e4net.demo.repository.goods.GoodsRepo;
import net.e4net.demo.repository.merchant.MerchantRepo;
import net.e4net.demo.security.CustomModelMapper;


@Service
@Transactional
@Slf4j
public class SellerService {
    @Autowired private GoodsRepo goodsRepo;
    @Autowired private MerchantRepo merchantRepo;


    private CustomModelMapper customModelMapper;
    //ModelMapper는 Entity <-> DTO 간 객체 전환 및 매핑 반복작업 작업을 줄여주는 라이브러리다.
    //autowired의 후보가 필요함?
   // @Autowired의 사용이 더이사 권장 되지 않음, 특히 ModelMapper의 경우 Bean등록을 하는게 default 값이라 커스텀모델매퍼를 사용해서
    // bean등록을 함 앞으로는 스프링 컨테이너가 직접 관리하는 것이 권장되어서 bean사용을 하라고 메세지가 출력됨


    //    @Autowired private ModelMapper mm;

//Field mm in net.e4net.demo.service.AuthService required a bean of type 'org.modelmapper.ModelMapper' that could not be found.
//
//    The injection point has the following annotations:
//            - @org.springframework.beans.factory.annotation.Autowired(required=true)

    public Merchant insertMerchang(MerchantInsertDto mDto) {
        Merchant merchant = customModelMapper.map(mDto, Merchant.class);
        TbMember tbmember = (TbMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        merchant.setMemberSn(tbmember);
        return merchantRepo.save(merchant);
    }

    public Goods insertGoods(GoodsInsertDto gDto) {
        Goods goods = customModelMapper.map(gDto, Goods.class);
        Optional<Merchant> mer = merchantRepo.findById(gDto.getMerchantSn());
        if(! mer.isPresent()) {
            throw new RuntimeException("가맹점이 존재하지 않습니다.");
        }
        goods.setMerchantSn(mer.get());
        goods.setGoodsSellQtt(0L);
        //YYYYMMDD(8) + 7 ///15
        String todate = new SimpleDateFormat("yyyyMMdd").format(new Date());

        List<String> strs = goodsRepo.selectTodayGoodsSnForSequence(todate);
        log.debug("stsr : {}, {}, {}", strs, strs.size(), todate + String.format("%07d", strs.size()+1));

        goods.setGoodsSn(todate + String.format("%07d", strs.size()+1));
        return goodsRepo.save(goods);
    }

}

