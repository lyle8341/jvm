package com.lyle.jvm.unsafe;

/**
 * 
 * @author Lyle
 * @date 2019-05-14 上午10:11
 * @version v1.0
 * @since 1.8  
 */
public class UnsafeTest {

  private long address = 0;

  public static void opStrArray(){
    String[] strings = new String[]{"1","2","3"};
    long i = MyUnsafe.getUnsafe().arrayBaseOffset(String[].class);
    System.out.println("string[] base offset is :" + i);

    //every index scale
    long scale = MyUnsafe.getUnsafe().arrayIndexScale(String[].class);
    System.out.println("string[] index scale is " + scale);


//print first string in strings[]
    System.out.println("first element is :" + MyUnsafe.getUnsafe().getObject(strings, i));
    System.out.println("second element is :" + MyUnsafe.getUnsafe().getObject(strings, i+scale));
    System.out.println("third element is :" + MyUnsafe.getUnsafe().getObject(strings, i+scale*2));

  }
  public static void opIntArray(){
    Integer[] integers = new Integer[]{22,222,2222};
    long i = MyUnsafe.getUnsafe().arrayBaseOffset(Integer[].class);
    System.out.println("Integer[] base offset is :" + i);

    //every index scale
    long scale = MyUnsafe.getUnsafe().arrayIndexScale(Integer[].class);
    System.out.println("Integer[] index scale is " + scale);


//print first Integer in Integer[]
    System.out.println("first element is :" + MyUnsafe.getUnsafe().getObject(integers, i));
    System.out.println("second element is :" + MyUnsafe.getUnsafe().getObject(integers, i+scale));
    System.out.println("third element is :" + MyUnsafe.getUnsafe().getObject(integers, i+scale*2));

  }


  public static void main(String[] args){
    opStrArray();
    opIntArray();
  }
}