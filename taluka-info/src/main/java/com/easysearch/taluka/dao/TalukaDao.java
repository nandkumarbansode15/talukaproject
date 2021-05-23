package com.easysearch.taluka.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.easysearch.taluka.pojo.Taluka;

@Repository
public interface TalukaDao extends MongoRepository<Taluka, Integer>{

}
