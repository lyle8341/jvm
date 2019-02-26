#### object

[JOL (Java Object Layout)](http://openjdk.java.net/projects/code-tools/jol/)

+ use api
  1. implementation 'org.openjdk.jol:jol-core:0.9'
  2. com.lyle.jvm.jol.JolDemo
+ Command Line Tool
  ```bash
  java -jar jol-cli/target/jol-cli.jar internals java.util.HashMap
  java -jar jol-cli/target/jol-cli.jar externals java.util.PriorityQueue
  java -jar jol-cli/target/jol-cli.jar footprint java.util.Hashtable
  java -jar jol-cli/target/jol-cli.jar estimates java.math.BigInteger
  java -jar jol-cli/target/jol-cli.jar heapdump heapdump.hprof
  ```
      Java对象占用空间是8字节对齐的，即所有Java对象占用bytes数必须是8的倍数。例如，一个包含两个属性的对象：int和byte，这个对象需要占用8+4+1=13个字节，这时就需要加上大小为3字节的padding进行8字节对齐，最终占用大小为16个字节  
  
> Shallow Size:
对象自身占用的内存大小，不包括它引用的对象  
> Retained Size:当前对象大小+当前对象可直接或间接引用到的对象的大小总和。
换句话说，Retained Size就是对象本身连同其无法从 GC 根到达的相关对象一起删除后释放的内存大小

Java对象保存在内存中时，由以下三部分组成:
1. 对象头
    1. Mark Word:包含一系列的标记位，比如轻量级锁的标记位，偏向锁标记位等
    2. Class Pointer:指向对象对应的Class对象（其对应的元数据对象）的内存地址
    3. Length:数组长度（只有数组对象才有）
2. 实例数据
3. 对齐填充字节

> **对象头**  
>> 静态属性不算在对象大小内

|os(bits)|compress|MarkWord(bytes)|Class Pointer(bytes)|reference(bytes)|
|:------:|:------:|:-------------:|:------------------:|:--------------:|
|   32   |        |       4       |          4         |        4       |
|   64   |   no   |       8       |          8         |        8       |
|   64   |   yes  |       8       |          4         |        4       |

> [Primitives](http://btoddb-java-sizing.blogspot.com/)

|Primitive Type|Memory Required(bytes)|
|:------------:|:--------------------:|
|  boolean     |          1           |
|  byte        |          1           |
|  short       |          2           |
|  char        |          2           |
|  int         |          4           |
|  float       |          4           |
|  long        |          8           |
|  double      |          8           |

> [Arrays](http://btoddb-java-sizing.blogspot.com/)

|    Field   | Type |  Size(bytes)  |
|:----------:|:----:|:-------------:|
|HEADER		   |      |       16      |
|length	     |  int	|       4       |
|PADDING		 |      |       4       |
|MEMORY BLOCK|      |      size     |
|PADDING		 |      |      pad      |
|Total		   |      |24 + size + pad|

    0 byte array size = 24 (size = 0, pad = 0)
    1 byte array size = 32 (size = 1, pad = 7)
    8 byte array size = 32 (size = 8, pad = 0)
    9 byte array size = 40 (size = 9, pad = 7)
    
> [String Object](http://btoddb-java-sizing.blogspot.com/)  

|Field   | Type    |Size (bytes)|
|:------:|:-------:|:----------:|
|HEADER  |         |    16      |
|value   | char[]  |    8       |
|offset  | int     |    4       |
|count   | int     |    4       |
|hash    | int     |    4       |
|PADDING |         |    4       |
|TOTAL   |         |    40      |
> Notice the 4 bytes at the end of the object for padding
      
    1.The actual data is allocated in another block of heap space (even if the string length is zero, it appears a char[0] array is allocated.) If the string's length is L, then the heap usage follows the usage for an array with char (2 byte) elements:
    24 + 0 * 2 = 24
        So an empty String object requires 64 bytes of heap space
    2.nother example: How much space does the string, "Smart" require on the heap?
    64 + 5*2 = 74 (nope! don't forget about the 8 byte alignment)
    3.char primitives are 2 bytes long, so 5 of them requires 10 bytes, but 10 isn't 8 byte aligned, so must round up to 16. So a string 5 characters long requires:
      64 + 5*2 + 6 = 80  6 bytes of padding）
      
      
#### summary
+ Use primitives when possible
+ Use "-XX:+UseCompressedOops" if your heap is less than 32gb      