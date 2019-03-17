package com.lyle.jvm.example;

/**
 * 长期存活对象进入老年代
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class LongLivedObj {

  //java -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 com.lyle.jvm.example.LongLivedObj
  public static void main(String[] args) {
    byte[] allocation1, allocation2, allocation3;
    allocation1 = new byte[Unit.MB / 4];
    allocation2 = new byte[4 * Unit.MB];
    allocation3 = new byte[4 * Unit.MB];
    allocation3 = null;
    allocation3 = new byte[4 * Unit.MB];
  }
}