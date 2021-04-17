package com.easysearch.shop.shopinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easysearch.shop.shopinfo.pojo.ShopDetails;

@Repository
public interface ShopDao extends JpaRepository<ShopDetails,Long>{

}
