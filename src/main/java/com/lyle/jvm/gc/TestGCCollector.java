package com.lyle.jvm.gc;

/**
 * 测试垃圾收集器
 * java -XX:+PrintFlagsFinal -version |grep JVMParamName
 * @author Lyle
 * @date 2019-02-26 下午9:47
 * @version v1.0
 * @since 1.8  
 */
public class TestGCCollector {

  public static void main(String[] args) throws InterruptedException {
    byte[] a = new byte[1024*1024*2];
    System.gc();
    Thread.sleep(1000000);
  }
}