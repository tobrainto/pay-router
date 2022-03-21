package com.tobrainto.pay.router.wechat;

import com.tobrainto.pay.router.param.PayParam;
import com.tobrainto.pay.router.param.PayResult;
import com.tobrainto.pay.router.StrategyHandler;
import org.springframework.stereotype.Component;

/**
 * @author : uwoerla
 * @date : 2022/3/18
 */
@Component
public class WeChatPayV2Handler implements StrategyHandler<PayParam, PayResult> {

    @Override
    public PayResult apply(PayParam param) {
        System.out.println("WeChatPayV2Handler");
        return null;
    }

}
