# pay-router

```
通用的"策略责任树"框架

通过树形结构实现策略的分发与委托，每一层通过指定的参数进行向下分发与委托，直到最终的执行者。

该框架包含两个类：{@code AbstractStrategyRouter} 和 {@code StrategyHandler}
通过实现 {@code AbstractStrategyRouter} 抽象类完成策略的分发，
通过实现 {@code StrategyHandler} 接口完成策略的实现。

如同第二层 A、B 这样的节点，既是 Root 节点的策略实现者，也是下游策略的分发者，
这样的节点需要继承 {@code StrategyHandler} 类并实现 {@code AbstractStrategyRouter} 接口。
           +---------+
           |  Root   |   ----------- 第 1 层策略入口 并 根据入参 P1 进行策略分发
           +---------+
            /       \
           /         \
     +------+      +------+
     |  A   |      |  B   |  ------- 第 2 层不同策略的实现 并 根据 根据入参 P2 进行策略分发
     +------+      +------+
       /  \          /  \
      ....................   ------- 第 n-1 层不同策略的实现 并 根据 根据入参 Pn-1 进行策略分发
      /    \        /    \
   +---+  +---+  +---+  +---+
   |X1 |  |X2 |  |Y1 |  |Y2 |  ----- 第 n 层不同策略的实现
   +---+  +---+  +---+  +---+
```

## test 
```
curl -X POST "http://localhost:9099/api/pay/router/test?type=ALI&version=V1" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=ALI&version=V2" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=WECHAT&version=V1" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=WECHAT&version=V2" -H "accept: */*"
```
