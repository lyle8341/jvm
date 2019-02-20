package com.lyle.jol;

/**
 * 数组对象
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class ArrayObject {

  int[] a = new int[0];

  //未压缩
  /*
  header(8+8) + 8(reference)=24
  24+[header(8+8) + 8(4_length+4_padding) + 0*4 + 0(padding)]=48 //int[0]
  24+[header(8+8) + 8(4_length+4_padding) + 1*4 + 4(padding)]=56 //int[1]
  24+[header(8+8) + 8(4_length+4_padding) + 2*4 + 0(padding)]=56 //int[2]
  24+[header(8+8) + 8(4_length+4_padding) + 3*4 + 4(padding)]=64 //int[3]
  24+[header(8+8) + 8(4_length+4_padding) + 4*4 + 0(padding)]=64 //int[4]
  24+[header(8+8) + 8(4_length+4_padding) + 5*4 + 4(padding)]=72 //int[5]
  24+[header(8+8) + 8(4_length+4_padding) + 6*4 + 0(padding)]=72 //int[6]
  24+[header(8+8) + 8(4_length+4_padding) + 7*4 + 4(padding)]=80 //int[7]
  24+[header(8+8) + 8(4_length+4_padding) + 8*4 + 0(padding)]=80 //int[8]
  24+[header(8+8) + 8(4_length+4_padding) + 9*4 + 4(padding)]=88 //int[9]
  24+[header(8+8) + 8(4_length+4_padding) + 10*4 + 0(padding)]=88 //int[10]
   */

  //压缩
  /*
  header(8+4) + 4(reference)=16
  16+[header(8+4) + 4(length) + 0*4 + 0(padding)]=32 //int[0]
  16+[header(8+4) + 4(length) + 1*4 + 4(padding)]=40 //int[1]
  16+[header(8+4) + 4(length) + 2*4 + 0(padding)]=40 //int[2]
  16+[header(8+4) + 4(length) + 3*4 + 4(padding)]=48 //int[3]
  16+[header(8+4) + 4(length) + 4*4 + 0(padding)]=48 //int[4]
  16+[header(8+4) + 4(length) + 5*4 + 4(padding)]=56 //int[5]
  16+[header(8+4) + 4(length) + 6*4 + 0(padding)]=56 //int[6]
  16+[header(8+4) + 4(length) + 7*4 + 4(padding)]=64 //int[7]
  16+[header(8+4) + 4(length) + 8*4 + 0(padding)]=64 //int[8]
  16+[header(8+4) + 4(length) + 9*4 + 4(padding)]=72 //int[9]
  16+[header(8+4) + 4(length) + 10*4 + 0(padding)]=72 //int[10]


   */
}