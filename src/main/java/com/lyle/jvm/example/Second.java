package com.lyle.jvm.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
public class Second {

  public static void main(String[] args) {
    Pause.pause();
    List<byte[]> list = new ArrayList<>();
    list.add(new byte[5*Unit.MB]);
  }
}