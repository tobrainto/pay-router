package com.tobrainto.pay.router.ali;

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
public class AliPayRouter extends AbstractStrategyRouter<PayParam, PayResult> implements StrategyHandler<PayParam, PayResult> {

    @Autowired
    private AliPayV1Handler aliPayV1Handler;
    @Autowired
    private AliPayV2Handler aliPayV2Handler;

    @Override
    public PayResult apply(PayParam param) {
        System.out.println("AliPayHandler");
        return this.selectThenApply(param);
    }


    @Override
    protected StrategyMapper<PayParam, PayResult> strategyMapper() {
        return param -> {
            if("V1".equals(param.getVersion())){
                return aliPayV1Handler;
            }else if("V2".equals(param.getVersion())){
                return  aliPayV2Handler;
            }
            return null;
        };
    }
}
