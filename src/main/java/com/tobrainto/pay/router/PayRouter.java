package com.tobrainto.pay.router;

import com.tobrainto.pay.router.ali.AliPayRouter;
import com.tobrainto.pay.router.param.PayParam;
import com.tobrainto.pay.router.param.PayResult;
import com.tobrainto.pay.router.wechat.WeChatPayRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于 责任树 模型实现的支付路由（demo）
 *
 * @author : uwoerla
 * @date : 2022/3/18
 */
@Component
public class PayRouter extends AbstractStrategyRouter<PayParam, PayResult> {

    @Autowired
    private AliPayRouter aliPayRouter;
    @Autowired
    private WeChatPayRouter weChatPayRouter;
    @Override
    protected StrategyMapper<PayParam, PayResult> strategyMapper() {
        return param -> {
            if("ALI".equals(param.getType())){
                return aliPayRouter;
            }else if("WECHAT".equals(param.getType())){
                return weChatPayRouter;
            }
            return null;
        };
    }

}
