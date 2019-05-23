#### 堆结构

#jdk7
![jdk7](jdk7.png)
+ 永久代的垃圾回收和老年代的垃圾回收是绑定的
+ 字符串常量池的字符串被存储在永久代中
+ JVM堆内存包括Java堆区域 和 永久代区域。因此，永久代不属于Java堆

#jdk8
![jdk8](jdk8.png)

+ 新生代GC：minor GC
+ 老年代GC：major GC(或者full GC)