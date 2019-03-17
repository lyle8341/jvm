package com.lyle.jvm.example;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class Test {

  public static void main(String[] args) throws Exception{
    byte[] n1 = new byte[7900 * 1000];
    n1 = null;
    System.gc();
//    Thread.sleep(5000);

  }
}