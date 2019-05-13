package com.lyle.jvm.concurrent.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * @author Lyle
 * @date 2019-05-08 下午2:50
 * @version v1.0
 * @since 1.8  
 */
public class Task implements Runnable {

  @Override
  public void run() {
    int ttt = Integer.parseInt("TTT");
    System.out.println("解析完成: " + ttt);
  }


  static class ExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
      System.out.printf("An exception has been captured\n");
      System.out.printf("Thread: %s\n",t.getId());
      System.out.printf("Exception: %s: %s\n",e.getClass().getName(),e.getMessage());
      System.out.printf("Stack Trace: \n");
      e.printStackTrace(System.out);
      System.out.printf("Thread status: %s\n",t.getState());
    }
  }

  public static void main(String[] args) {
    Task task = new Task();
    Thread t = new Thread(task);
    t.setUncaughtExceptionHandler(new ExceptionHandler());
    t.start();
  }
}