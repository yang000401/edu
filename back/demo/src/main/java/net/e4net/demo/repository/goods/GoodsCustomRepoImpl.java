package net.e4net.demo.repository.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import net.e4net.demo.entity.Goods;
import net.e4net.demo.entity.QGoods;

@Repository
public class GoodsCustomRepoImpl implements GoodsCustomRepo{
    @Autowired private JPAQueryFactory qf;

    @Override
    public List<String> selectTodayGoodsSnForSequence(String todate) {
        QGoods qgoods = QGoods.goods;
        return qf.select(qgoods.goodsSn).from(qgoods).where(qgoods.goodsSn.contains(todate)).fetch();
    }

    @Override
    public List<Goods> selectAllGoods() {
        QGoods qgoods = QGoods.goods;
        return qf.selectFrom(qgoods).fetch();
    }

    @Override
    public Goods selectValidateGoods(String goodsSn) {
        QGoods qgoods = QGoods.goods;
        return qf.selectFrom(qgoods).where(qgoods.useYn.eq("Y").and(qgoods.goodsSn.eq(goodsSn))).fetchOne();
    }
}
