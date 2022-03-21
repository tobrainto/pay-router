```
curl -X POST "http://localhost:9099/api/pay/router/test?type=ALI&version=V1" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=ALI&version=V2" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=WECHAT&version=V1" -H "accept: */*"

curl -X POST "http://localhost:9099/api/pay/router/test?type=WECHAT&version=V2" -H "accept: */*"
```