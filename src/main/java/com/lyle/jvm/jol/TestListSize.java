package com.lyle.jvm.jol;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.openjdk.jol.info.GraphLayout;

/**
 * 测试list集合大小
 * @author Lyle
 * @date 2019-11-09 上午10:30
 * @version v1.0
 * @since 1.8  
 */
public class TestListSize {

  public static void main(String[] args) throws Exception{
    //10w 身份证 8.04MB
    //50w 身份证 40.2MB
    List<String> collect = Files.readAllLines(Paths.get("/home/lyle/Downloads/zjhm.txt"));
    System.out.println("共有:-->" + collect.size());

//    System.out.println(ClassLayout.parseClass(collect.getClass()).toPrintable());
//    System.out.println("对象内部信息：" + ClassLayout.parseInstance(collect).toPrintable());
//    System.out.println("对象外部信息：" + GraphLayout.parseInstance(collect).toPrintable());
    System.out.println("对象总大小："+GraphLayout.parseInstance(collect).totalSize());


  }
}