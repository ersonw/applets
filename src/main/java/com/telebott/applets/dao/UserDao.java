package com.telebott.applets.dao;

import com.alibaba.fastjson.JSONObject;
import com.telebott.applets.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    public User findAllById(String userId){
        AggregationResults<User> results = mongoTemplate.aggregate(newAggregation(
                match(Criteria.where("id").is(userId))
                , Aggregation.sort(Sort.Direction.ASC,"addTime")
                ,Aggregation.limit(1)
        ), "user", User.class);
        if(results.getMappedResults().isEmpty()) return null;
        return results.getMappedResults().get(0);
    }
}
