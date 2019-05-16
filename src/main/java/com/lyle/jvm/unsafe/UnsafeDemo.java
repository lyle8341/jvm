package com.lyle.jvm.unsafe;

/**
 * 
 * @author Lyle
 * @date 2019-05-14 下午4:00
 * @version v1.0
 * @since 1.8  
 */
public class UnsafeDemo {
//
  public static void main(String[] args) throws Exception{

    //突破限制创建实例
    PrivateBean p = (PrivateBean) MyUnsafe.getUnsafe().allocateInstance(PrivateBean.class);
    System.out.println(p.getAge()); // Print 0

    p.setAge(45); // Let's now set age 45 to un-initialized object
    System.out.println(p.getAge()); // Print 45

  }
}