#### 堆结构

#jdk7
![jdk7](jdk7.png)
+ 永久代的垃圾回收和老年代的垃圾回收是绑定的
+ 字符串常量池的字符串被存储在永久代中

#jdk8
![jdk8](jdk8.png)

+ 新生代GC：minor GC
+ 老年代GC：major GC(或者full GC)