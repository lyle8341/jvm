package com.lyle.jvm.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * 
 * @author Lyle
 * @date 2019-05-14 下午3:57
 * @version v1.0
 * @since 1.8  
 */
public class MyUnsafe {

  public static Unsafe getUnsafe() {
    try{
      Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      return (Unsafe)f.get(null);
    }catch(Exception e) {
      throw new IllegalStateException();
    }
  }
}