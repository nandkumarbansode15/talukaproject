package com.easysearch.shop.shopinfo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easysearch.shop.shopinfo.pojo.ShopDetails;

@Repository
public interface ShopDao extends JpaRepository<ShopDetails,Long>{

	List<ShopDetails> findAllByShopCity(String city);

}
