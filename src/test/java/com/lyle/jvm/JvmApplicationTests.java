package com.lyle.jvm;

import com.lyle.jvm.proxy.dynamic.apply.BizService;
import com.lyle.jvm.proxy.dynamic.apply.BizServiceInvocationHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import javax.annotation.Resource;
import org.junit.Test;

public class JvmApplicationTests extends BaseTest {

  @Resource
  private BizService bizServiceImpl;

  @Test
  public void contextLoads() {
    InvocationHandler handler = new BizServiceInvocationHandler<>(bizServiceImpl);
    BizService proxy = (BizService) Proxy.newProxyInstance(BizService.class.getClassLoader(),new Class[]{BizService.class},handler);
    final String openId = proxy.getOpenId();
    final String score = proxy.score(openId);
    final boolean authorized = proxy.authorized(score);
    System.out.println(authorized);
  }
}