package com.lyle.classmexer;

import com.javamex.classmexer.MemoryUtil;
import java.io.IOException;

/**
 * @see  <a href="https://www.jianshu.com/p/91e398d5d17c">https://www.jianshu.com/p/91e398d5d17c</a>
 *
 * VM options:
 * -javaagent:/home/lyle/Jars/caches/modules-2/files-2.1/classmexer/classmexer/0.03/a757aaa03f67e5aeffc041a616e8b89ac2e01627/classmexer-0.03.jar
 * -XX:+UseCompressedOops
 */
public class TestObjectSize {

    int a;//4
    int b;//8
    //静态属性不算在对象大小内
    static int c;

    public static void main(String[] args) throws IOException {
        TestObjectSize testObjectSize = new TestObjectSize();
        // 打印对象的shallow size
        System.out.println("Shallow Size: " + MemoryUtil.memoryUsageOf(testObjectSize) + " bytes");
        // 打印对象的 retained size
        System.out.println("Retained Size: " + MemoryUtil.deepMemoryUsageOf(testObjectSize) + " bytes");
    }

}