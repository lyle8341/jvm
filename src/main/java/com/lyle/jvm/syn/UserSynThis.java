package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class UserSynThis {

  public void addUser(){
    synchronized (this){
      System.out.println("andUser");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void delUser(){
   synchronized (this){
     System.out.println("delUser");
   }
  }

  /**
   *    UserSynThis obj = new UserSynThis();
   *     new Thread(obj::addUser).start();
   *     new Thread(obj::delUser).start();
   *     同一个对象,需要等待锁的释放
   *
   *    UserSynThis obj = new UserSynThis();
   *     new Thread(obj::addUser).start();
   *     UserSynThis obj2 = new UserSynThis();
   *     new Thread(obj2::delUser).start();
   *     不同对象,互不影响
   *
   */
}