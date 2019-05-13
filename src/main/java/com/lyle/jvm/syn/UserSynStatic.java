package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class UserSynStatic {

  public synchronized static void addUser(){
      System.out.println("andUser");
      Pause.sleep(5000);
  }

  public synchronized static void delUser(){
     System.out.println("delUser");
  }

  /**
   *    UserSynStatic synStatic = new UserSynStatic();
   *     UserSynStatic synStatic2 = new UserSynStatic();
   *     new Thread(()->{synStatic.addUser();}).start();
   *     new Thread(()->{synStatic2.delUser();}).start();
   *     静态方法,锁的是类
   *
   */
}