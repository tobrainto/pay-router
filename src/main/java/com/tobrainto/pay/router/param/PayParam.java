package com.tobrainto.pay.router.param;

import lombok.Data;

/**
 * @author : uwoerla
 * @date : 2022/3/18
 */
@Data
public class PayParam {

    private String type;
    private String version;
    private AliPayParam aliPayParam;
    private WeChatPayParam weChatPayParam;

}
