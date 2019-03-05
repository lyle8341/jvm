package com.lyle.jvm.example;

import java.util.Scanner;

/**
 * 等待分析观察
 *
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
abstract class Pause {

  static void pause() {
    Scanner scanner = new Scanner(System.in);
    scanner.next();
  }
}