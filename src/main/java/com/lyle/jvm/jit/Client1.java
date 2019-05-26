package com.lyle.jvm.jit;

import java.util.ArrayList;
import java.util.List;

public class Client1 {

  public static void main(String[] args) {
    arrayListTest();
//    arrayTest();
  }

  private static void arrayListTest() {
    List<Object> list = new ArrayList<>();
    Object obj = new Object();
    // 填充数据
    for (int i = 0; i < 200000; i++) {
      list.add(obj);
    }
    long start;

    start = System.nanoTime();
    // 初始化时已经计算好条件
    for (int i = 0, n = list.size(); i < n; i++) {
    }
    System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");

    start = System.nanoTime();
    // 在判断条件中计算
    for (int i = 0; i < list.size(); i++) {
    }
    System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");
  }

  private static void arrayTest() {
    Object[] objects = new Object[200000];
    Object obj = new Object();
    // 填充数据
    for (int i = 0; i < 200000; i++) {
      objects[i] = obj;
    }
    long start;

    start = System.nanoTime();
    // 初始化时已经计算好条件
    for (int i = 0, n = objects.length; i < n; i++) {
    }
    System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");

    start = System.nanoTime();
    // 在判断条件中计算
    for (int i = 0; i < objects.length; i++) {
    }
    System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");
  }
}