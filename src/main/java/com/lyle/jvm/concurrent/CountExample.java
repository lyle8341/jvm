package com.lyle.jvm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * https://www.bilibili.com/video/av45946533/?p=10
 *
 * @author Lyle
 * @version v1.0
 * @date 2019-05-28 下午2:12
 * @since 1.8
 */
public class CountExample {

  private static int threadTotal = 200;
  private static int clientTotal = 5000;

  private static long count = 0;

  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    Semaphore semaphore = new Semaphore(threadTotal);
    for (int i = 0; i < clientTotal; i++) {
      service.execute(() -> {
        try {
          semaphore.acquire();
          add();
          semaphore.release();
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
    service.shutdown();
    System.out.println("count:" + count);
  }

  private static void add() {
    count++;
  }
}