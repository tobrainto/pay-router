package com.tobrainto.pay.controller;

import com.tobrainto.pay.router.PayRouter;
import com.tobrainto.pay.router.param.PayParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay/router/")
@Slf4j
public class TestController {

  @Autowired
  private PayRouter payRouter;

  @PostMapping("/test")
  @ResponseBody
  public boolean test(PayParam param) {
    log.info("param: {}",param);
    payRouter.selectThenApply(param);
    return Boolean.TRUE;
  }
}