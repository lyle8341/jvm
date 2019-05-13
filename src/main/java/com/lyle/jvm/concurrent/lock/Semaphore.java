package com.lyle.jvm.concurrent.lock;

/**
 * 信号量
 * @author Lyle
 * @date 2019-05-13 上午10:23
 * @version v1.0
 * @since 1.8  
 */
public class Semaphore {

  private boolean signal = false;

  public synchronized void take(){
    this.signal = true;
    this.notify();
  }

  public synchronized void release() throws InterruptedException{
    while (!this.signal){
      wait();
    }
    this.signal = false;
  }








}