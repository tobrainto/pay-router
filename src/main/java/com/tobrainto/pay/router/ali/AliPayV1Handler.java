package com.tobrainto.pay.router.ali;

import com.tobrainto.pay.router.param.PayParam;
import com.tobrainto.pay.router.param.PayResult;
import com.tobrainto.pay.router.StrategyHandler;
import org.springframework.stereotype.Component;

/**
 * @author : uwoerla
 * @date : 2022/3/18
 */
@Component
public class AliPayV1Handler implements StrategyHandler<PayParam, PayResult> {

    @Override
    public PayResult apply(PayParam param) {
        System.out.println("AliPayV1Handler");
        return null;
    }

}
