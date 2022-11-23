package net.e4net.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.e4net.demo.common.Cd;
import net.e4net.demo.entity.CmmnCodeDetail;
import net.e4net.demo.repository.cmmn_code_detail.CmmnCodeDetailRepo;
@Component
public class EntityUtil {
    @Autowired private CmmnCodeDetailRepo ccdRepo;

    public CmmnCodeDetail getMemberTyCmm(String codeValue) {
        return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MEMBER_TY, codeValue);
    }

    public CmmnCodeDetail getMemberSttusCmm(String codeValue) {
        return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MEMBER_STTUS, codeValue);
    }

    public CmmnCodeDetail getMoneyTransferCmm(String codeValue) {
        return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MONEY_TSF_TY_CODE, codeValue);
    }

    public CmmnCodeDetail getMoneyMeanCmm(String codeValue) {
        return ccdRepo.findByCodeIdAndCodeValue(Cd.CODE_ID_MONEY_MEAN_CODE, codeValue);
    }
}
