package com.lyle.jvm.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * https://blog.csdn.net/xifeijian/article/details/79991913
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class AgentDemo {

  /**
   * 该方法在main方法之前运行，与main方法运行在同一个JVM中
   */
  public static void premain(String agentArgs, Instrumentation inst) {
    System.out.println("=========premain方法执行1========");
    System.out.println(agentArgs);
  }

  /**
   * 如果不存在 premain(String agentArgs, Instrumentation inst)
   * 则会执行 premain(String agentArgs)
   */
  public static void premain(String agentArgs) {
    System.out.println("=========premain方法执行2========");
    System.out.println(agentArgs);
  }

  /**
   * 1、agentArgs 是 premain 函数得到的程序参数，随同 “– javaagent”一起传入。与 main 函数不同的是，
   * 这个参数是一个字符串而不是一个字符串数组，如果程序参数有多个，程序将自行解析这个字符串。
   * 2、Inst 是一个 java.lang.instrument.Instrumentation 的实例，由 JVM 自动传入。
   * java.lang.instrument.Instrumentation 是 instrument 包中定义的一个接口，也是这个包的核心部分，
   * 集中了其中几乎所有的功能方法，例如类定义的转换和操作等等。
   *
   *
   * 使用：
   * 1.在 src 目录下生成 META-INF/MANIFEST.MF 文件,project structure--->artifacts--->add--->jar---> from module with dependencies
   *
   * 2.build--->build artifacts--->
   *
   * 3.VM options:
   * -javaagent:/home/lyle/IdeaProjects/jvm/out/artifacts/jvm_jar/jvm.jar=hello -javaagent:/home/lyle/IdeaProjects/jvm/out/artifacts/jvm_jar/jvm.jar=world
   *
   * 4.java -javaagent ..... -jar ....(如果你把 -javaagent 放在 -jar 后面，则不会生效。也就是说，放在主程序后面的 agent 是无效的)
   *
   *
   */
}