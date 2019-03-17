package com.lyle.jvm.pass_by_value_not_pass_by_reference;

/**
 * <a href="https://www.journaldev.com/3884/java-is-pass-by-value-and-not-pass-by-reference">java-is-pass-by-value-and-not-pass-by-reference</a>
 * 值传递
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class PassByValue {

  public static void main(String[] args) {
    Balloon red = new Balloon("Red"); //memory reference 50
    Balloon blue = new Balloon("Blue"); //memory reference 100
    swap(red, blue);
    System.out.println("red color="+red.getColor());
    System.out.println("blue color="+blue.getColor());
    foo(blue);
    System.out.println("blue color="+blue.getColor());
  }

  private static void swap(Object o1, Object o2){ //o1=50, o2=100
    Object temp = o1; //temp=50, o1=50, o2=100
    o1=o2; //temp=50, o1=100, o2=100
    o2=temp; //temp=50, o1=100, o2=50
  } //method terminated

  private static void foo(Balloon balloon) { //baloon=100
    balloon.setColor("Red"); //baloon=100
    balloon = new Balloon("Green"); //baloon=200
    balloon.setColor("Blue"); //baloon = 200
  }
}