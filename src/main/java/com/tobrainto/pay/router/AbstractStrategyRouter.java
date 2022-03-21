package com.tobrainto.pay.router;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * 通用的"策略责任树"框架
 *
 * 通过树形结构实现策略的分发与委托，每一层通过指定的参数进行向下分发与委托，直到最终的执行者。
 *
 * 该框架包含两个类：{@code AbstractStrategyRouter} 和 {@code StrategyHandler}
 * 通过实现 {@code AbstractStrategyRouter} 抽象类完成策略的分发，
 * 通过实现 {@code StrategyHandler} 接口完成策略的实现。
 *
 * 如同第二层 A、B 这样的节点，既是 Root 节点的策略实现者，也是下游策略的分发者，
 * 这样的节点需要继承 {@code StrategyHandler} 类并实现 {@code AbstractStrategyRouter} 接口。
 *
 * <pre>
 *           +---------+
 *           |  Root   |   ----------- 第 1 层策略入口 并 根据入参 P1 进行策略分发
 *           +---------+
 *            /       \
 *           /         \
 *     +------+      +------+
 *     |  A   |      |  B   |  ------- 第 2 层不同策略的实现 并 根据 根据入参 P2 进行策略分发
 *     +------+      +------+
 *       /  \          /  \
 *      ....................   ------- 第 n-1 层不同策略的实现 并 根据 根据入参 Pn-1 进行策略分发
 *      /    \        /    \
 *   +---+  +---+  +---+  +---+
 *   |X1 |  |X2 |  |Y1 |  |Y2 |  ----- 第 n 层不同策略的实现
 *   +---+  +---+  +---+  +---+
 * </pre>
 *
 * @author : uwoerla
 * @date : 2022/3/18
 *
 */
@Component
public abstract class AbstractStrategyRouter<P, R> {

    /**
     * 策略映射器，根据指定的入参路由到对应的策略处理者。
     *
     * @param <P> 策略的 入参类型
     * @param <R> 策略的 返回值类型
     */
    public interface StrategyMapper<P, R> {
        /**
         * 根据入参获取对应的策略处理者。
         * 可基于 if-else 实现
         * 也可基于 map 实现。
         *
         * @param
         */
        StrategyHandler<P, R> select(P param);
    }

    @Getter
    @Setter
    @SuppressWarnings("unchecked")
    private StrategyHandler<P, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    private StrategyMapper<P, R> strategyMapper;

    /**
     * 类初始化时绑定分发策略
     */
    @PostConstruct
    private void init() {
        strategyMapper = strategyMapper();
        Objects.requireNonNull(strategyMapper, "strategyMapper cannot be null");
    }

    /**
     * 策略的分发逻辑
     * 抽象方法
     * 子类需要实现
     */
    protected abstract StrategyMapper<P, R> strategyMapper();

    /**
     * 选择并执行策略
     * 框架会根据策略分发至下游的 Handler 进行处理
     *
     * @param
     */
    public R selectThenApply(P param) {
        final StrategyHandler<P, R> strategyHandler = strategyMapper.select(param);
        if (strategyHandler == null) {
            return defaultStrategyHandler.apply(param);
        }
        return strategyHandler.apply(param);
    }

}