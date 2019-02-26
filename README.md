# jvm
summary jvm

+ java启动参数
   1. 标准参数(-),所有的JVM实现都必须实现这些参数的功能，而且向后兼容；
   2. 非标准参数(-X),默认jvm实现这些参数的功能，但是并不保证所有jvm实现都满足，且不保证向后兼容；
   3. 非Stable参数(-XX),此类参数各个jvm实现会有所不同，将来可能会随时取消，需要慎重使用；

+ 查看jvm参数

      jps    #JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。
      jstat  #JVM statistics Monitoring是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。
      jmap   #JVM Memory Map命令用于生成heap dump文件
      jhat   #JVM Heap Analysis Tool命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，生成dump的分析结果后，可以在浏览器中查看
      jstack #用于生成java虚拟机当前时刻的线程快照。
      jinfo  #JVM Configuration info 这个命令作用是实时查看和调整虚拟机运行参数。
      javap  #查看经javac之后产生的JVM字节码代码，自动解析.class文件, 避免了去理解class文件格式以及手动解析class文件内容
      jcmd   #几乎集合了jps、jstat、jinfo、jmap、jstack所有功能，一个多功能工具, 可以用来导出堆, 查看Java进程、导出线程信息、 执行GC、查看性能相关数据等
      
      sudo jinfo -flags 5670
      sudo jmap -heap 8842
      jcmd 5670 VM.flags
      jcmd 2209 help

+ Metaspace

  * 元空间的本质和永久代类似，都是对**JVM规范中方法区**的实现
  * Class对象是存放在堆区的，不是方法区，
  * 类的元数据(类的方法代码，变量名，方法名，访问权限，返回值等等都是在方法区的)