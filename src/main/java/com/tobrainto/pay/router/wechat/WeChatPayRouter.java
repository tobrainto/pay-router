package com.tobrainto.pay.router.wechat;

import com.tobrainto.pay.router.AbstractStrategyRouter;
import com.tobrainto.pay.router.param.PayParam;
import com.tobrainto.pay.router.param.PayResult;
import com.tobrainto.pay.router.StrategyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : uwoerla
 * @date : 2022/3/18
 */
@Component
public class WeChatPayRouter extends AbstractStrategyRouter<PayParam, PayResult> implements StrategyHandler<PayParam, PayResult> {

    @Autowired
    private WeChatPayV1Handler weChatPayV1Handler;
    @Autowired
    private WeChatPayV2Handler weChatPayV2Handler;
    @Override
    public PayResult apply(PayParam param) {
        System.out.println("WeChatPayHandler");
        return this.selectThenApply(param);
    }

    @Override
    protected StrategyMapper<PayParam, PayResult> strategyMapper() {
        return param -> {
            if ("V1".equals(param.getVersion())) {
                return weChatPayV1Handler;
            } else if ("V2".equals(param.getVersion())) {
                return weChatPayV2Handler;
            }
            return null;
        };
    }

}
