package com.lyle.jvm.unsafe;

import java.lang.reflect.Field;

/**
 * @author Lyle
 * @version v1.0
 * @date 2019-05-15 上午10:16
 * @since 1.8
 */
public class FinalTest {

  private final String id = "c";

  private static final long idOffset;

  static {
    try {
      idOffset = MyUnsafe.getUnsafe().objectFieldOffset(FinalTest.class.getDeclaredField("id"));
    } catch (Exception e) {
      throw  new Error();
    }
  }


  public static void main(String[] args) throws Exception {
    FinalTest test = new FinalTest();
    // Unsafe修改属性
    MyUnsafe.getUnsafe().putObject(test, idOffset, "d");
    System.out.println(test.id);// 输出c
    System.out.println(MyUnsafe.getUnsafe().getObject(test, idOffset));// Unsafe.getObject输出d
    Field idField = FinalTest.class.getDeclaredField("id");
    idField.setAccessible(true);
    System.out.println(idField.get(test));// 反射输出d
  }

}