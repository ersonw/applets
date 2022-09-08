package com.telebott.applets.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(includeFieldNames = true)
@Setter
@Getter
@Document(collection = "ePay")
public class EPay {
    @Id
    private String id;
    private String url;
    private String mchId=null;
    private String secretKey=null;
    private String callbackUrl=null;
    private String notifyUrl=null;
    private boolean enable=false;
    private long addTime=0L;
    private long updateTime=0L;
}
