package com.lyle.jvm.classmexer;

import com.javamex.classmexer.MemoryUtil;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 测试list大小
 * @author Lyle
 * @date 2019-11-09 上午10:04
 * @version v1.0
 * @since 1.8  
 */
public class TestListSize {

  public static void main(String[] args) throws Exception{
    //10w身份证的list  8.04MB
    //50w身份证的list  40.2MB
    List<String> collect = Files.readAllLines(Paths.get("/home/lyle/Downloads/zjhm.txt"));
    System.out.println("共有:-->" + collect.size());
    // 打印对象的shallow size
    System.out.println("Shallow Size: " + MemoryUtil.memoryUsageOf(collect) + " bytes");
    // 打印对象的 retained size
    System.out.println("Retained Size: " + MemoryUtil.deepMemoryUsageOf(collect) + " bytes");

  }
}