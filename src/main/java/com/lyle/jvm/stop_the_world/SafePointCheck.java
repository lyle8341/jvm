package com.lyle.jvm.stop_the_world;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <pre>
 *   -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime
 * </pre>
 *
 * <pre>
 * -XX:+PrintSafepointStatistics -XX:PrintSafepointStatisticsCount=1
 *
 * </pre>
 */
public class SafePointCheck {

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      try {
        Collection<Object> list = new ArrayList<>();
        list.add(new byte[1024 * 1024]);
        Object obj = new byte[1024 * 1024];
      } catch (OutOfMemoryError e) {

      }
    }
  }
}