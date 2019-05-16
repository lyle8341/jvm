package com.lyle.jvm.unsafe;

/**
 * <pre>
 *
 * As the original answer says: Unsafe.allocateMemory() is a wrapper around os::malloc
 * which doesn't care about any memory limits imposed by the VM.
 *
 * ByteBuffer.allocateDirect() will call this method but before that,
 * it will call Bits.reserveMemory() (In my version of Java 7: DirectByteBuffer.java:123)
 * which checks the memory usage of the process and throws the exception which you mention
 * </pre>
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M 不起作用
 * @author Lyle
 * @date 2019-05-14 上午11:23
 * @version v1.0
 * @since 1.8  
 */
public class UnsafeTest2 {

  private static final long _1MB = 1024 * 1024;
  private static final long _1GB = _1MB * 1024;

  public static void main(String[] args) {
    MyUnsafe.getUnsafe().allocateMemory(_1GB * 20);
  }


}