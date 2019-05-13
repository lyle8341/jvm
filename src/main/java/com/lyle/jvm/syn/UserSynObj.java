package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class UserSynObj {

  private final Object lock = new Object();

  public void addUser(){
    synchronized (lock){
      System.out.println("andUser");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void delUser(){
   synchronized (lock){
     System.out.println("delUser");
   }
  }

  /**
   *     UserSynObj obj = new UserSynObj();
   *     new Thread(obj::addUser).start();
   *     new Thread(obj::delUser).start();
   *     同一个对象,需要等待锁释放
   *
   *    UserSynObj obj = new UserSynObj();
   *     new Thread(obj::addUser).start();
   *     UserSynObj obj2 = new UserSynObj();
   *     new Thread(obj2::delUser).start();
   *     不同对象,互补影响
   *
   *
   *
   */
}