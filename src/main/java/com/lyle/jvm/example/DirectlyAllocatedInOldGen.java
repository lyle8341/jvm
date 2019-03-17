package com.lyle.jvm.example;

/**
 * 直接在老年代分配
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class DirectlyAllocatedInOldGen {

  //-XX:PretenureSizeThreshold=3145728  所占用内存大于该值(单位byte)的对象直接分配到老年代，3145728为3MB
  //java -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728 com.lyle.jvm.example.DirectlyAllocatedInOldGen
  public static void main(String[] args) {
    byte[] allocation;
    allocation = new byte[4 * Unit.MB];
  }
}