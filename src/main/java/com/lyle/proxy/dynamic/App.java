package com.lyle.proxy.dynamic;

import com.lyle.proxy.Person;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Lyle
 * @version v1.0
 * @date 2019-02-17 下午5:14
 * @since 1.8
 */
public class App {

  public static void main(String[] args) {
    Person lisi = new Student("lisi");
    InvocationHandler handler = new StuInvocationHandler<>(lisi);
    Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
    stuProxy.giveMoney();
  }
}