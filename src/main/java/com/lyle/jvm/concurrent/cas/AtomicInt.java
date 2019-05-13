package com.lyle.jvm.concurrent.cas;

/**
 * https://www.cnblogs.com/inspred/p/9520805.html
 *
 * @author Lyle
 * @version v1.0
 * @date 2019-05-13 下午2:17
 * @since 1.8
 */
public class AtomicInt {

  /**
   *
   * @param var1 对象的引用(AtomicInteger里面存的值看成是工作内存中的值)
   * @param var2 AtomicInteger中被volatile关键字修饰的value在内存中的偏移量
   * @param var4 delta the value to add
   * @return the previous value
   */
  public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
      //用对象的引用(var1)以及偏移量(var2)从内存中拿到值,然后将这个值作为compareAndSwapInt方法的期望值
      var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

    return var5;
  }

  /**
   * 得到的底层当前的值(把底层的值看成是主内存中的值)
   * @param var1
   * @param var2
   * @return
   */
  public native int getIntVolatile(Object var1, long var2);

  /**
   * 进行原子更新操作
   * @param var1
   * @param var2
   * @param var4
   * @param var5
   * @return
   */
  public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);

}