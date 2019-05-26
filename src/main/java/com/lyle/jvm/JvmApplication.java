package com.lyle.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -XX:+PrintCodeCache
 * -XX:ReservedCodeCacheSize=256M
 * jinfo -flag ReservedCodeCacheSize pid
 * JVM退出时打印了CodeCache使用情况
 */
@SpringBootApplication
public class JvmApplication {

  public static void main(String[] args) {
    SpringApplication.run(JvmApplication.class, args);
  }

}