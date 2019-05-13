package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class UserSynClass {

  public void addUser(){
      synchronized (UserSynClass.class){
        System.out.println("andUser");
        Pause.sleep(5000);
      }
  }

  public void delUser(){
     synchronized (UserSynClass.class){
       System.out.println("delUser");
     }
  }

  /**
   *     UserSynClass synClass = new UserSynClass();
   *     UserSynClass synClass2 = new UserSynClass();
   *     new Thread(()->{synClass.addUser();}).start();
   *     new Thread(()->{synClass2.delUser();}).start();
   *     锁定的是类
   */
}