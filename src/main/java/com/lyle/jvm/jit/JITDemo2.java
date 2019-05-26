package com.lyle.jvm.jit;

import java.util.Random;

public class JITDemo2 {

  private static Random random = new Random();

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int count = 0;
    int i = 0;
    while (i++ < 99999999) {
      count += plus();
    }
    System.out.println("time cost : " + (System.currentTimeMillis() - start));
  }

  private static int plus() {
    return random.nextInt(10);
  }
}

//测试结果见jit.md