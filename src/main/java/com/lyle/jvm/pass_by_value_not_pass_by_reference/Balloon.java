package com.lyle.jvm.pass_by_value_not_pass_by_reference;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class Balloon {

  private String color;

  public Balloon() {
  }

  public Balloon(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}