package com.lyle.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class EmptyObject {

  String s = "test";

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(EmptyObject.class).toPrintable());
    EmptyObject obj = new EmptyObject();
    System.out.println("对象内部信息：" + ClassLayout.parseInstance(obj).toPrintable());
    System.out.println("对象外部信息：" + GraphLayout.parseInstance(obj).toPrintable());
    System.out.println("对象总大小："+GraphLayout.parseInstance(obj).totalSize());
  }
}