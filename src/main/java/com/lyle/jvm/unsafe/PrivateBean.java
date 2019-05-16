package com.lyle.jvm.unsafe;

/**
 * 
 * @author Lyle
 * @date 2019-05-14 下午3:56
 * @version v1.0
 * @since 1.8  
 */
public class PrivateBean {

  private int age;

  private PrivateBean(){

  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}