package com.telebott.applets.util;

import com.telebott.applets.dao.UserDao;
import com.telebott.applets.dao.WechatAuthDao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Component
@Slf4j
public class Utils {
    private static Utils self;
    @Autowired
    private WechatAuthDao wechatAuthDao;
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void initPost(){
        self = this;
        log.info("DAO加载成功！\n");
    }
    public static WechatAuthDao getWechatAuthDao(){
        return self.wechatAuthDao;
    }
    public static UserDao getUserDao(){
        return self.userDao;
    }
}
