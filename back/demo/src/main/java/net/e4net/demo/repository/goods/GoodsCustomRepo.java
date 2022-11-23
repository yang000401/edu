package net.e4net.demo.repository.goods;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.Goods;

@Repository
public interface GoodsCustomRepo {
    List<String> selectTodayGoodsSnForSequence(String todate);
    List<Goods> selectAllGoods();

    Goods selectValidateGoods(String goodsSn);
}
