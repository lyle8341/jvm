package com.lyle.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class JolDemo {

  public static void main(String[] args) {
    final VolatileLong obj = new VolatileLong();
    final String s = ClassLayout.parseInstance(obj).toPrintable();
    System.out.println("对象内部信息：" + s);
    final String s1 = GraphLayout.parseInstance(obj).toPrintable();
    System.out.println("对象外部信息：" + s1);
    final long s2 = GraphLayout.parseInstance(obj).totalSize();
    System.out.println("对象总大小：" + s2);
    System.out.println("hashcode:" + obj.hashCode());
  }
}