#### jstat(JVM statistics Monitoring)

类装载，内存，垃圾收集，jit编译的信息

```jvm
jstat -gcutil 19515 [间隔] [次数]
```

      S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT   
     20.72   0.00  21.55  63.88  92.49  89.60   2020   47.882    94   20.976   68.859
     S0: s0利用率
     S1: s1利用率
     E: Eden利用率
     O: 老年代利用率
     M: metaspace利用率
     CCS: 压缩类空间利用率
     YGC: 新生代GC次数
     YGCT: 新生代GC时间
     FGC: full gcc次数
     FGCT: full gc时间
     GCT: 总垃圾收集时间