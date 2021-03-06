#### 垃圾收集器

> There is a term that you should know before learning about GC. The term is "stop-the-world." Stop-the-world will occur no matter which GC algorithm you choose. Stop-the-world means that the JVM is stopping the application from running to execute a GC. When stop-the-world occurs, every thread except for the threads needed for the GC will stop their tasks. The interrupted tasks will resume only after the GC task has completed. GC tuning often means reducing this stop-the-world time

+ 1 . Serial  
![serial](serial.jpg)
  + **复制算法**
  + -XX:+UseSerialGC
  + must not be used on an operating server
  + 新生代的一个单线程的GC
  + *stop-the-world*

+ 2 . ParNew  
![parnew](parnew.jpg)
  + **复制算法**
  + 新生代的收集器
  + *stop-the-world*

+ 3 . Parallel Scavenge
  + **复制算法**
  + 新生代收集器
  + 并行收集，面向吞吐量要求
  + *stop-the-world*
---
+ 4 . Serial Old
  + **标记-整理算法**
  + 老年代收集器版本，单线程
  + *stop-the-world*

+ 5 . Parallel Old
  + **标记-整理算法**
  + Parallel Scavenge收集器的老年代版本
  + *stop-the-world*

+ 6 . CMS  
![cms](cms.jpg)
  + **标记-清除算法**
  + 老年代收集器
  + -XX:ParallelCMSThreads=
  + -XX:+UseConcMarkSweepGC
  + *初始化标记和重新标记两个阶段仍然会发生stop-the-world*

+ 7 . G1(Garbage First)
  * -XX:+UseG1GC
  * G1将整个堆划分为多个大小相等的独立区域
  * 保留新生代和老年代的分代概念(但两者不再是物理隔离的)
  * 从整体来看是基于**标记整理算法**，从局部（两个Region之间）来看是**基于复制算法**
  * 使用多个GC线程，每次优先回收价值最大的Region
  * _young gc phases_
    - G1 stops the world
    - G1 builds a "collection set"
      - the regions that will be subject to collction
    - in a young gc,the collection set contains:
      - eden regions
      - survivor regions
    - First phase:**Root Scanning**
      - static and local objects are scanned
    - Second phase:**Update RS**
      - drains the dirty card queue to update the RS
    - Third phase:**Process RS**
      - detect the eden objects pointed by old objects
    - Fourth phase:**Object Copy**
      - the object graph is traversed
      - live objects copied to survivor/old region
    - Fifth phase:**Reference Processing**
      - soft,weak,phantom,final jni weak references
      - always enable -XX:+ParallelRefProcEnabled
      - more details with -XX:+PrintReferenceGC
  * _old gc phase_
    - G1 stops the world
    - performs a young gc
      - Piggybacks old region roots detection(initial-mark)
    - G1 resumes application threads
    - concurrent old region marking proceeds
      - keeps track of references(soft,weak,etc)
      - computes per-region liveness information
    - G1 stops the world
    - remark phase
      - SATB queue processing
      - Reference processing
    - cleanup phase
      - empty old regions are immediately recycled
    - application threads are resumed
    - cleanup phase->recycles empty old regions
    - non-empty old regions processing
      - happens during the next young gc cycle
      - no rush to clean the garbage in old regions
  * G1 mixed GC
    - "Mixed" GC - piggybacked on young gcs
    - the collection set includes
      - part of the remaining old regions to collect
      - eden regions
      - survivor regions
    - algorithm is identical to(相同) young gc
      - stop-the-world,parallel,copying     
    - old regions with most garbage are chosen first
    - G1 wastes some heap space
    - Mixed GCs are stopped
  * avoid at all costs full gcs
  * grep the gc logs for "Full GC"
    - use -XX:+PrintAdaptiveSizePolicy to know what caused it
  * avoid too many "humongous" allocations
    - Example
      - Max heap size 32G -> region size = 16M
      - Humongous limit -> 8M
      - allocations of 12M arrays
      - set region size to 32M
      - Humongous limit is now 16M
        - 12M arrays are not humongous anymore
       
       
       
       
       
          
            
        - G1 schedules an old GC based on heap usage
          - by default when the entire heap is 45% full
            - checke after a young gc or a humongous allocation
        - The old GC consists of old region marking    
          - finds all the live objects in the old regions
          - old region marking is concurrent
        - Concurrent marking
        - Snapshot-at-the-beginning(SATB)


+ 搭配问题
  + 有一个分代式GC框架，Serial(DefNew)/ParNew/CMS/Serial Old(MSC)都在这个框架内
  + ParallelScavenge与G1则不在这个框架内，而是各自采用了自己特别的框架。这是因为新的GC实现时发现原本的分代式GC框架用起来不顺手
  + **JVM仅指定新生代垃圾收集器的情况下，默认老年代采用Serial Old垃圾收集器（带压缩）**
    + -XX:+UseSerialGC  
      Serial (DefNew) + Serial Old（Serial Mark Sweep Compact）
    + -XX:+UseParNewGC  
      Parallel (ParNew) + Serial Old（Serial Mark Sweep Compact） 
    + -XX:+UseParallelGC  
      Parallel Scavenge (PSYoungGen) + Serial Old（Serial Mark Sweep Compact (PSOldGen)） 
      > 注：在Parallel Scavenge收集器架构中本身有PS MarkSweep收集器来进行老年代收集，但由于PS MarkSweep与Serial Old实现非常接近，因此官方的许多资料都直接以Serial Old代替PS MarkSweep进行讲解。
    + Parallel Old（带压缩）只能与Parallel Scavenge进行组合  
      -XX:+UseParallelOldGC  
      Parallel Scavenge (PSYoungGen) + Parallel Mark Sweep Compact (ParOldGen)
  + CMS（不带压缩）可以与Serial和ParNew进行组合，共2种组合
    + -XX:-UseParNewGC -XX:+UseConcMarkSweepGC  
      Serial (DefNew) + CMS（Concurrent Mark Sweep）
    + -XX:+UseParNewGC -XX:+UseConcMarkSweepGC  
      Parallel (ParNew) + CMS（Concurrent Mark Sweep） + Serial Old（Serial Mark Sweep Compact）

  ![compose](combinations.png)
  + 总结
    - Serial Old(MSC)可以与所有新生代收集器进行组合，共3种组合
    - Parallel Old（带压缩）只能与Parallel Scavenge进行组合
    - CMS（不带压缩）可以与Serial和ParNew进行组合，共2种组合


+ 推荐使用的2种GC组合

  ![recommand](recommand.png)
  + 1.基于低停顿时间的垃圾收集器  
    -XX:+UseConcMarkSweepGC（该参数隐式启用-XX:+UseParNewGC）
  + 2.基于吞吐量优先的垃圾收集器  
    -XX:+UseParallelOldGC（该参数隐式启用-XX:+UseParallelGC）


+ 9 . 对比  
![compare](Types-of-Java-Garbage-Collectors3_th_thumb.jpg)

+ 10 . scavenger
  + 没有独立的 _mark_ 与 _copy_ 阶段的，而是合在一起做一个动作，就叫scavenge
   （或evacuate，或者就叫copy）。也就是说，每发现一个这次收集中尚未访问过的活对象就
    直接copy到新地方，同时设置forwarding pointer。  
    
    
+ 11 . ParallelScavenge和ParNew区别
  * 1 . PS以前是广度优先顺序来遍历对象图的，JDK6的时候改为默认用深度优先顺序遍历，并留有一个UseDepthFirstScavengeOrder参数来选择是用深度还是广度优先。在JDK6u18之后这个参数被去掉，**PS变为只用深度优先遍历**,**ParNew则是一直都只用广度优先顺序来遍历**
  * 2 . PS完整实现了adaptive size policy，而ParNew及“分代式GC框架”内的其它GC都没有实现完（倒不是不能实现，就是麻烦+没人力资源去做）。所以千万千万别在用ParNew+CMS的组合下用UseAdaptiveSizePolicy，请只在使用UseParallelGC或UseParallelOldGC的时候用它。
  * 3 . ParNew可以跟CMS搭配使用，而ParallelScavenge不能。

> **Heap后面的内容为进程退出时输出当前内存各区域的分配情况**
+ -XX:UseSerialGC

      Heap
       def new generation   total 57856K, used 1544K [0x0000000705800000, 0x00000007096c0000, 0x0000000743aa0000)
        eden space 51456K,   3% used [0x0000000705800000, 0x0000000705982038, 0x0000000708a40000)
        from space 6400K,   0% used [0x0000000708a40000, 0x0000000708a40000, 0x0000000709080000)
        to   space 6400K,   0% used [0x0000000709080000, 0x0000000709080000, 0x00000007096c0000)
       tenured generation   total 128384K, used 2591K [0x0000000743aa0000, 0x000000074b800000, 0x00000007c0000000)
         the space 128384K,   2% used [0x0000000743aa0000, 0x0000000743d27d68, 0x0000000743d27e00, 0x000000074b800000)
       Metaspace       used 2980K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 325K, capacity 388K, committed 512K, reserved 1048576K
        
+ -XX:+UseParNewGC

      Heap
       par new generation   total 57856K, used 514K [0x0000000705800000, 0x00000007096c0000, 0x0000000743aa0000)
        eden space 51456K,   1% used [0x0000000705800000, 0x0000000705880bb0, 0x0000000708a40000)
        from space 6400K,   0% used [0x0000000708a40000, 0x0000000708a40000, 0x0000000709080000)
        to   space 6400K,   0% used [0x0000000709080000, 0x0000000709080000, 0x00000007096c0000)
       tenured generation   total 128384K, used 2617K [0x0000000743aa0000, 0x000000074b800000, 0x00000007c0000000)
         the space 128384K,   2% used [0x0000000743aa0000, 0x0000000743d2e7d8, 0x0000000743d2e800, 0x000000074b800000)
       Metaspace       used 3014K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 330K, capacity 388K, committed 512K, reserved 1048576K

+ -XX:+UseParallelGC

      Heap
       PSYoungGen      total 56320K, used 486K [0x0000000781d80000, 0x0000000785c00000, 0x00000007c0000000)
        eden space 48640K, 1% used [0x0000000781d80000,0x0000000781df9b10,0x0000000784d00000)
        from space 7680K, 0% used [0x0000000784d00000,0x0000000784d00000,0x0000000785480000)
        to   space 7680K, 0% used [0x0000000785480000,0x0000000785480000,0x0000000785c00000)
       ParOldGen       total 128512K, used 2617K [0x0000000705800000, 0x000000070d580000, 0x0000000781d80000)
        object space 128512K, 2% used [0x0000000705800000,0x0000000705a8e7d8,0x000000070d580000)
       Metaspace       used 3014K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 330K, capacity 388K, committed 512K, reserved 1048576K


+ -XX:+UseParallelOldGC

      Heap
       PSYoungGen      total 56320K, used 486K [0x0000000781d80000, 0x0000000785c00000, 0x00000007c0000000)
        eden space 48640K, 1% used [0x0000000781d80000,0x0000000781df9b10,0x0000000784d00000)
        from space 7680K, 0% used [0x0000000784d00000,0x0000000784d00000,0x0000000785480000)
        to   space 7680K, 0% used [0x0000000785480000,0x0000000785480000,0x0000000785c00000)
       ParOldGen       total 128512K, used 2617K [0x0000000705800000, 0x000000070d580000, 0x0000000781d80000)
        object space 128512K, 2% used [0x0000000705800000,0x0000000705a8e7d8,0x000000070d580000)
       Metaspace       used 3014K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 330K, capacity 388K, committed 512K, reserved 1048576K


+ -XX:-UseParNewGC -XX:+UseConcMarkSweepGC

      Heap
       def new generation   total 57856K, used 514K [0x0000000705800000, 0x00000007096c0000, 0x000000070ab30000)
        eden space 51456K,   1% used [0x0000000705800000, 0x0000000705880bb0, 0x0000000708a40000)
        from space 6400K,   0% used [0x0000000708a40000, 0x0000000708a40000, 0x0000000709080000)
        to   space 6400K,   0% used [0x0000000709080000, 0x0000000709080000, 0x00000007096c0000)
       concurrent mark-sweep generation total 128384K, used 2622K [0x000000070ab30000, 0x0000000712890000, 0x00000007c0000000)
       Metaspace       used 3014K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 330K, capacity 388K, committed 512K, reserved 1048576K
> warning: Using the DefNew young collector with the CMS collector is deprecated and will likely be removed in a future release        
        
+ -XX:+UseParNewGC -XX:+UseConcMarkSweepGC  
   
      Heap
       par new generation   total 57856K, used 514K [0x0000000705800000, 0x00000007096c0000, 0x000000071a4c0000)
        eden space 51456K,   1% used [0x0000000705800000, 0x0000000705880bb0, 0x0000000708a40000)
        from space 6400K,   0% used [0x0000000708a40000, 0x0000000708a40000, 0x0000000709080000)
        to   space 6400K,   0% used [0x0000000709080000, 0x0000000709080000, 0x00000007096c0000)
       concurrent mark-sweep generation total 128384K, used 2622K [0x000000071a4c0000, 0x0000000722220000, 0x00000007c0000000)
       Metaspace       used 3015K, capacity 4496K, committed 4864K, reserved 1056768K
        class space    used 330K, capacity 388K, committed 512K, reserved 1048576K     

+ 看懂GC日志
  - GC日志中的PSYoungGen（PS是指Parallel Scavenge）eden space 加上一个 survivor space (也就是from space)的大小，另外一个survivor space (也就是to space)是用来通过复制算法存放存活对象的，不在回收区域之内
    > minor
  
                                                GC前      eden+from        GC后   heap
          [GC (Allocation Failure) [PSYoungGen: 5635K->352K(7168K)] 5635K->1384K(19456K), 0.0016548 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
                                                       GC后         GC前
  
    > major 
       
                                              GC前   eden+from                     GC后   old     GC前          heap                GC前        metaspace
          [Full GC (System.gc()) [PSYoungGen: 320K->0K(7168K)] [ParOldGen: 2064K->1278K(12288K)] 2384K->1278K(19456K), [Metaspace: 2476K->2476K(1056768K)], 0.0039614 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
                                                    GC后                    GC前                         GC后                              GC后
  
    > _待确认_
    
          GC后堆大小=GC后PSYoungGen+oldGen-used
    
        
+ 名词解释
  > **DefNewGeneration**: default new generation  
    **ParNewGeneration**: parallel new generation  
    **MSC**: MarkSweepCompact  
    **Scavenge或者叫scavenging GC**: copying GC的另一種叫法而已  
    **PSMarkSweep**: ParallelScavenge的MarkSweep(LISP2演算法的mark-compact收集器)  
    **PSCompact**: ParallelScavenge-MarkCompact  
    **mutator**: 本意是改变者  
    **Footprint**:占用的空间  
    **intern**:保留/驻留  
        


+ 并发标记算法
  - 三色扫描算法（白，灰，黑）
  - 在并发标记时，引用可能产生变化，白色对象有可能被错误回收
  - 解决方案：
    - SATB（snapshot at the beginning）-----G1采用
    - Incremental Update ------CMS采用


        
**Reference**
>[名词解释][1]

[1]: https://www.itread01.com/content/1547992271.html "名词解释"  
  
        
        
        
        