/**
 * -XX:+PrintGCDateStamps -XX:+PrintGCDetails
 * -XX:+PrintGC 输出GC日志
 * -XX:+PrintGCDetails 输出GC的详细日志
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（垃圾收集发生的时间，自JVM启动以后以秒计量,如 0.050）
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2019-03-10T21:39:54.515+0800）
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * -Xloggc:../logs/gc.log 日志文件的输出路径<br>
 * <b>命令行执行
 * <p>
 * 在/home/lyle/IdeaProjects/jvm/out/production/classes 目录下执行
 * </p>
 * </b>
 * 查看堆参数:sudo jmap -heap 10391
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
package com.lyle.jvm.example;