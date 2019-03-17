package com.lyle.jvm.example;

/**
 *  <b>新生代Minor GC</b>
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class MinorGCTest {

  //java -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC com.lyle.jvm.example.MinorGCTest
  public static void main(String[] args) {
    byte[] allocation1,allocation2,allocation3,allocation4;
    allocation1 = new byte[2 * Unit.MB];
    allocation2 = new byte[2 * Unit.MB];
    allocation3 = new byte[2 * Unit.MB];
    allocation4 = new byte[4 * Unit.MB];
  }
}