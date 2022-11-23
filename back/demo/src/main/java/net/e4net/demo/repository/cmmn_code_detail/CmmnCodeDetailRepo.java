package net.e4net.demo.repository.cmmn_code_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.CmmnCodeDetail;

@Repository
public interface CmmnCodeDetailRepo extends JpaRepository<CmmnCodeDetail, Long>, CmmnCodeDetailCustomRepo{
    CmmnCodeDetail findByCodeIdAndCodeValue(String codeId, String codeValue);
}
