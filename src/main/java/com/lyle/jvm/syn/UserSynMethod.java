package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class UserSynMethod {

  public synchronized void addUser(){
      System.out.println("andUser");
      Pause.sleep(5000);
  }

  public synchronized void delUser(){
     System.out.println("delUser");
  }
  /**
   * UserSynMethod method = new UserSynMethod();
   * new Thread(method::addUser).start();
   * new Thread(method::delUser).start();
   * 同一个对象,需要等待锁释放
   *
   * UserSynMethod method = new UserSynMethod();
   * new Thread(method::addUser).start();
   * UserSynMethod method2 = new UserSynMethod();
   * new Thread(method2::delUser).start();
   * 不同对象,互补影响
   *
   *
   *
   */
}