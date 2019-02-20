package com.lyle.jol;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class StringObject {

  String s = "test";

  /*
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {

    private final char value[];

    private int hash; // Default to 0
}

   */

/*  一个string对象本身
    压缩：header(8+4)+4(char[] reference)+4(int)+4(padding)=24
  未压缩：header(8+8)+8(char[] reference)+4(int)+4(padding)=32

    一个char[]
    压缩：header(8+4)+4(length)+0*2+0(padding)=16
  未压缩：header(8+8)+8(4_length+4_padding)+0*2+0(padding)=24
                    ||
    压缩：24+16+0*2+0(padding)=40+0*2+padding
  未压缩：32+24+0*2+0(padding)=56+0*2+padding

*/

//压缩
  //16 + [40 + 4*2 + 0] = 64

//未压缩
  //24 + [56 + 4*2 + 0] = 88


//未压缩


}