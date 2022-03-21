package com.tobrainto.pay.router;

/**
 * @author : uwoerla
 * @date : 2022/3/18
 */
public interface StrategyHandler<P, R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = param -> null;

    /**
     * 执行策略
     *
     * @param
     */
    R apply(P param);
}