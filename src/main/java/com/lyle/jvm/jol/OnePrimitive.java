package com.lyle.jvm.jol;

/**
 * 一个简单类型
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class OnePrimitive {
  int a;
  //未压缩
  /*
  header(8+8) + 4(int) + 4(padding)=24
   */
  //压缩
  /*
  header(8+4) + 4(int) + 0(padding)=16
   */
}