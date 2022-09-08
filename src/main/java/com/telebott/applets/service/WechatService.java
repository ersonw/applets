package com.telebott.applets.service;

import com.telebott.applets.data.ResponseData;
import com.telebott.applets.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WechatService {
    public ResponseData test(User user, String ip) {
        return ResponseData.success();
    }
}
