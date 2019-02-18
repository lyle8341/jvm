#### object

[JOL (Java Object Layout)](http://openjdk.java.net/projects/code-tools/jol/)

+ use api
  1. implementation 'org.openjdk.jol:jol-core:0.9'
  2. com.lyle.jol.JolDemo
+ Command Line Tool
  ```bash
  java -jar jol-cli/target/jol-cli.jar internals java.util.HashMap
  java -jar jol-cli/target/jol-cli.jar externals java.util.PriorityQueue
  java -jar jol-cli/target/jol-cli.jar footprint java.util.Hashtable
  java -jar jol-cli/target/jol-cli.jar estimates java.math.BigInteger
  java -jar jol-cli/target/jol-cli.jar heapdump heapdump.hprof
  ```

Java对象保存在内存中时，由以下三部分组成:
1. 对象头
    1. Mark Word
    2. 指向类的指针
    3. 数组长度（只有数组对象才有）
2. 实例数据
3. 对齐填充字节