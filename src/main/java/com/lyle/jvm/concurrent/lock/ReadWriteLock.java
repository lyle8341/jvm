package com.lyle.jvm.concurrent.lock;

/**
 * 读写锁
 * @author Lyle
 * @date 2019-05-13 上午9:59
 * @version v1.0
 * @since 1.8  
 */
public class ReadWriteLock {

  private int readCount = 0;

  private int writeCount = 0;

  //获取读锁,读锁在写锁不存在的时候才能获取
  public synchronized void lockRead() throws InterruptedException{
    //写锁存在,需要wait
    while (writeCount > 0){
      wait();
    }
    readCount++;
  }

  //释放读锁
  public synchronized void unLockRead(){
    readCount--;
    notifyAll();
  }

  public synchronized void lockWrite() throws InterruptedException{
    //判断是否有写锁
    while (writeCount > 0){
      wait();
    }

    writeCount++;

    while (readCount > 0){
      wait();
    }

  }

  //释放写锁
  public synchronized void unlockWrite(){
    writeCount--;
    notifyAll();
  }

}