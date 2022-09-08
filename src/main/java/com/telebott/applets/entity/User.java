package com.telebott.applets.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(includeFieldNames = true)
@Setter
@Getter
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String username=null;
    private String firstName=null;
    private String lastName=null;
    private String email=null;
    private String password=null;
    private String salt=null;
    private String phone=null;
    private String wechatId=null;
    private String alipayId=null;
    private long addTime=0;
    private long updateTime=0;
    private boolean verified=false;
    @Transient
    private String token;

    public static User getUser(String user) {
        if (StringUtils.isEmpty(user)) return null;
        return JSONObject.toJavaObject(JSONObject.parseObject(user), User.class);
    }
}
