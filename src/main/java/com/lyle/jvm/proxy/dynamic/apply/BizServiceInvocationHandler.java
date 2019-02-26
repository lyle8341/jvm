package com.lyle.jvm.proxy.dynamic.apply;

import com.lyle.jvm.proxy.dynamic.MonitorUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class BizServiceInvocationHandler<T> implements InvocationHandler {

  //目标对象
  private T target;

  public BizServiceInvocationHandler(T target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("代理执行" + method.getName() + "方法");
    MonitorUtil.start();
    final Object invoke = method.invoke(target, args);
    MonitorUtil.finish(method.getName());
    return invoke;
  }
}