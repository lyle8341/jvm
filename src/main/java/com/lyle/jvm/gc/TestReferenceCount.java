package com.lyle.jvm.gc;

/**
 * 证明虚拟机没有采用引用计数算法
 * -verbose:gc -XX:+PrintGCDetails
 *
 * @author Lyle
 * @date 2019-02-24 上午10:04
 * @version v1.0
 * @since 1.8  
 */
public class TestReferenceCount {

  private Object object;

  private TestReferenceCount() {
    byte[] a = new byte[20*1024*1024];
  }

  public static void main(String[] args) {
    TestReferenceCount t1 = new TestReferenceCount();
    TestReferenceCount t2 = new TestReferenceCount();

    t1.object = t2;
    t2.object = t1;

    t1 = null;
    t2 = null;

    System.gc();
  }
}