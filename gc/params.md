#### 参数意义
  
```bash
#JVM参数的默认值可以通过
java -XX:+PrintFlagsFinal -version |grep JVMParamName
```

    Xss：每个线程的stack大小（栈）
    Xmx：JAVA HEAP的最大值、默认为物理内存的1/4
    Xms：JAVA HEAP的初始值，server端最好Xms与Xmx一样
    Xmn：JAVA HEAP young区的大小
~~XX:PermSize：设定内存的永久保存区域~~  
~~XX:MaxPermSize：设定最大内存的永久保存区域~~
   
    MetaspaceSize：Metaspace扩容时触发FullGC的初始化阈值，也是最小的阈值
    MaxMetaspaceSize：
    NewSize:新生代初始化内存的大小
    MaxnewSize:新生代可被分配的内存的最大上限
    Xmn:对newSize、MaxnewSize两个参数同时进行配置(注意：JDK1.4之后才有该参数)
    NewRatio:设置老年代(除去持久代)与新生代的比例
    SurvivorRatio:表示伊甸园区(Eden)是幸存区To大小的10倍(也是幸存区From的10倍)