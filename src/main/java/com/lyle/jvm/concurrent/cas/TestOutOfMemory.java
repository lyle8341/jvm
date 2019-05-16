package com.lyle.jvm.concurrent.cas;

import java.util.Map;
import java.util.Random;

/**
 * -Xmx100m -XX:+UseParallelGC
 * @author Lyle
 * @date 2019-05-14 下午2:04
 * @version v1.0
 * @since 1.8  
 */
public class TestOutOfMemory {

  public static void main(String[] args) {
    Map map = System.getProperties();
    Random r = new Random();
    while (true) {
      map.put(r.nextInt(), "value");
    }
  }

}