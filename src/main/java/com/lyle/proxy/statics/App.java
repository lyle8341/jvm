package com.lyle.proxy.statics;

import com.lyle.proxy.Person;

/**
 * 
 * @author Lyle
 * @date 2019-02-17 下午3:33
 * @version v1.0
 * @since 1.8  
 */
public class App {

  public static void main(String[] args) {
    //目标对象
    Person lisi = new Student("lyle");
    //代理对象
    Person monitor = new StudentProxy(lisi);
    monitor.giveMoney();
  }
}