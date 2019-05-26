package com.lyle.jvm.jit;

import java.util.Random;

/**
 * -XX:+PrintCompilation -XX:-TieredCompilation（关闭分层编译） 首先是根据方法调用触发（不涉及循环）
 */
public class JITDemo2_1 {

  private static Random random = new Random();

  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    int count = 0;
    int i = 0;
    while (i++ < 10000) {
//      System.out.println(i);
      count += plus();
    }
    System.out.println("time cost : " + (System.currentTimeMillis() - start));
    //TimeUnit.SECONDS.sleep(1200);
  }

  // 调用时，编译器计数器+1
  private static int plus() {
    return random.nextInt(10);
  }

}