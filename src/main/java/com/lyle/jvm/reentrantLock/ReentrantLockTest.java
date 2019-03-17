package com.lyle.jvm.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class ReentrantLockTest extends Thread{

  public static ReentrantLock lock = new ReentrantLock();
  public static int i = 0;

  public ReentrantLockTest(String name) {
    super.setName(name);
  }

  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      lock.lock();
//      lock.lock();
      System.out.println(lock.getHoldCount());
      System.out.println(lock.getQueueLength());
      try{
        System.out.println(this.getName());
        i++;
      }finally {
        lock.unlock();
      }
    }
  }


  public static void main(String[] args) throws InterruptedException {
    ReentrantLockTest test1 = new ReentrantLockTest("thread1");
    ReentrantLockTest test2 = new ReentrantLockTest("thread2");

    test1.start();
    test2.start();
    test1.join();
    test2.join();
    System.out.println(i);

  }
}