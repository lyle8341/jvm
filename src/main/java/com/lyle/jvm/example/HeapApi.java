package com.lyle.jvm.example;

/**
 * 通过java代码获取heap大小
 *
 * @author Lyle
 * @version v1.0
 * @date 2019-03-10 下午4:21
 * @since 1.8
 */
public class HeapApi {

  // java -Xmx20m -Xms20m -Xmn7m com.lyle.jvm.example.HeapApi
  // Xmx=19.5M  free mem=18.87639617919922M  total mem=19.5M
  public static void main(String[] args) {
    System.out.print("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
    System.out.print("  free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
    System.out.println("  total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
  }

}