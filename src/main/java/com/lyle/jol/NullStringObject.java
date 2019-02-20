package com.lyle.jol;

/**
 * 字符串对象
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class NullStringObject {

  private String s;

  //未压缩：16(header)+8（reference）=24
  //压缩：12（header）+4（reference）=16
}