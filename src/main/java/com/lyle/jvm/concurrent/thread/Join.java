package com.lyle.jvm.concurrent.thread;

import com.lyle.jvm.syn.Pause;

/**
 * 线程等待
 * @author Lyle
 * @date 2019-05-08 下午2:49
 * @version v1.0
 * @since 1.8  
 */
public class Join {

  public static void main(String[] args) {

    Thread a = new Thread(() -> {
      System.out.printf("线程 %s 开始执行\n", Thread.currentThread().getName());
      Pause.sleep(5000);
      System.out.printf("线程 %s 执行完毕\n", Thread.currentThread().getName());
    });
    // a.start();
    Thread b = new Thread(() -> {
      System.out.printf("线程 %s 开始执行\n", Thread.currentThread().getName());
      Pause.sleep(10000);
      System.out.printf("线程 %s 执行完毕\n", Thread.currentThread().getName());
    });
    b.start();

    try {
      a.join();

      b.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.printf("线程 %s 执行完毕\n", Thread.currentThread().getName());
  }
}