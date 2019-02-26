package com.lyle.jvm.proxy.statics;

import com.lyle.jvm.proxy.Person;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class Student implements Person {

  private String name;

  public Student(String name){
    this.name = name;
  }

  @Override
  public void giveMoney() {
    System.out.println(name + "上交班费50元");
  }
}