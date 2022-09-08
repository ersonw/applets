package com.telebott.applets.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(includeFieldNames = true)
@Setter
@Getter
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private String uid=null;
    private String tradeNo=null;
    private String outTradeNo=null;
    private Double money=0D;
    private Double totalFee=0D;
    private String ip=null;
    private long state =0;
    private long addTime=0L;
    private long updateTime=0L;
}
