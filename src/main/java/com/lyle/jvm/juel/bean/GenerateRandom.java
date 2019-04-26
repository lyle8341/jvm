package com.lyle.jvm.juel.bean;

import java.util.Random;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class GenerateRandom {

  public int generate(){
    Random r = new Random();
    return r.nextInt(200);
  }
}