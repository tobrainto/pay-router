package com.tobrainto.pay.controller;

import com.tobrainto.pay.router.PayRouter;
import com.tobrainto.pay.router.param.PayParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay/router/")
public class TestController {

  @Autowired
  private PayRouter payRouter;

  @PostMapping("/test")
  @ResponseBody
  public boolean test(PayParam param) {
    payRouter.selectThenApply(param);
    return Boolean.TRUE;
  }
}