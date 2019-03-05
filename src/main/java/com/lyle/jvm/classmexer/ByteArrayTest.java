package com.lyle.jvm.classmexer;

import com.javamex.classmexer.MemoryUtil;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
public class ByteArrayTest {

  byte[] arr = new byte[40 * 1024 * 1024];

  public static void main(String[] args) {
    ByteArrayTest byteArrayTest = new ByteArrayTest();
    // 打印对象的shallow size
    //压缩：8(MarkWord)+4(Class Pointer)+4(reference)+0(padding)=16
    //不压缩:8(MarkWord)+8(Class Pointer)+8(reference)+0(padding)=24
    System.out.println("Shallow Size: " + MemoryUtil.memoryUsageOf(byteArrayTest) + " bytes");
    // 打印对象的 retained size
    //压缩:16(Shallow Size)+[8(MarkWord)+4(Class Pointer)+4(length)+1*4(数组长度*4(int是4位))+4(padding)]=40
    //不压缩:24(Shallow Size)+[8(MarkWord)+8(Class Pointer)+8(length)+1*4(数组长度*4(int是4位))+0(padding)]=56
    System.out.println("Retained Size: " + MemoryUtil.deepMemoryUsageOf(byteArrayTest) + " bytes");
  }
}