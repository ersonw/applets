package com.telebott.applets.control;

import com.telebott.applets.data.ResponseData;
import com.telebott.applets.entity.User;
import com.telebott.applets.service.WechatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/wechat")
@Api(value = "/v1/wechat", tags = "微信接口")
public class WechatApi {
    @Autowired
    private WechatService service;
    @GetMapping("/test")
    public ResponseData dashboard(@RequestParam(value = "user",required = false) @ApiParam(hidden = true) String user,
                                  @RequestParam(value = "ip") @ApiParam(hidden = true) String ip){
        return service.test(User.getUser(user),ip);
    }
}
