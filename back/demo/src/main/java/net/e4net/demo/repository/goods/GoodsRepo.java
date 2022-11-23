package net.e4net.demo.repository.goods;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.e4net.demo.entity.Goods;

@Repository
public interface GoodsRepo extends JpaRepository<Goods, String>, GoodsCustomRepo{

}
