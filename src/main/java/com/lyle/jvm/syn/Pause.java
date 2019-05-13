package com.lyle.jvm.syn;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class Pause {

  /**
   * 睡眠等待
   * @param time 毫秒数
   */
  public static void sleep(long time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}