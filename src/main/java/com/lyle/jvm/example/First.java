package com.lyle.jvm.example;

/**
 * @author Lyle
 * @version v1.0
 * @date 2019-03-05 下午2:16
 * @since 1.8
 */
public class First {

  /**
   * java -Xmx50m -Xms10m com.lyle.jvm.example.First
   *
   * @param args
   */
  public static void main(String[] args) {
    //=====================Begin=========================
    System.out.print("Xmx=");
    System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

    System.out.print("free mem=");
    System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

    System.out.print("total mem=");
    System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    Pause.pause();
   /* //=====================First Allocated=========================
    System.out.println("5MB array allocated");
    byte[] b1 = new byte[5 * 1024 * 1024];

    System.out.print("Xmx=");
    System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

    System.out.print("free mem=");
    System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

    System.out.print("total mem=");
    System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

    //=====================Second Allocated=========================
    System.out.println("10MB array allocated");
    byte[] b2 = new byte[10 * 1024 * 1024];

    System.out.print("Xmx=");
    System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

    System.out.print("free mem=");
    System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

    System.out.print("total mem=");
    System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

    //=====================OOM=========================
    System.out.println("OOM!!!");
    System.gc();*/
    byte[] b3 = new byte[40 * 1024 * 1024];
  }
}