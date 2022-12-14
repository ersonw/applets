package com.telebott.applets.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telebott.applets.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Set;
import java.util.Timer;

@Repository
public class WechatAuthDao {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final Timer timer = new Timer();
    public void pushUser(User userToken){
        if (StringUtils.isNotEmpty(userToken.getToken())) {
            Set users = redisTemplate.opsForSet().members("user");
            assert users != null;
//        System.out.println(users.toString());
            for (Object user: users) {
                ObjectMapper objectMapper = new ObjectMapper();
                User userEntity = objectMapper.convertValue(user, User.class);
                if (userEntity.getToken().equals(userToken.getToken()) || Objects.equals(userEntity.getId(), userToken.getId())){
                    popUser(userEntity);
                }
            }
            redisTemplate.opsForSet().add("user",userToken);
        }
    }
    public void removeUser(User userToken){
        Set users = redisTemplate.opsForSet().members("user");
        if (users != null){
            for (Object user: users) {
                ObjectMapper objectMapper = new ObjectMapper();
                User userEntity = objectMapper.convertValue(user,User.class);
                if (userEntity.getToken().equals(userToken.getToken())){
                    popUser(userEntity);
                }
            }
        }
    }
    public void popUser(User userToken){
        redisTemplate.opsForSet().remove("user" ,userToken);
    }
    public User findUserByToken(String token) {
        Set users = redisTemplate.opsForSet().members("user");
        if (users != null){
            for (Object user: users) {
                ObjectMapper objectMapper = new ObjectMapper();
                User userEntity = objectMapper.convertValue(user,User.class);
                if (userEntity.getToken().equals(token)){
                    return userEntity;
                }
            }
        }
        return null;
    }
    public User findUserByUserId(String userId) {
        Set users = redisTemplate.opsForSet().members("user");
        if (users != null){
            for (Object user: users) {
                ObjectMapper objectMapper = new ObjectMapper();
                User userEntity = objectMapper.convertValue(user,User.class);
                if (Objects.equals(userEntity.getId(), userId)){
                    return userEntity;
                }
            }
        }
        return null;
    }
}
