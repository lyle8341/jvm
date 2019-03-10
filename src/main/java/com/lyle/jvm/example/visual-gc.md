#### 解释说明
1 . spaces区域：代表虚拟机内存分布情况



2 . Graphs区域：内存使用详细介绍
  -  Compile Time(编译时间)：6368compiles 表示编译总数，4.407s表示编译累计时间。一个脉冲表示一次JIT编译，窄脉冲表示持续时间短，宽脉冲表示持续时间长
  - Class Loader Time(类加载时间): 20869loaded表示加载类数量, 139 unloaded表示卸载的类数量，40.630s表示类加载花费的时间
  - GC Time(GC Time)：2392collections表示垃圾收集的总次数，37.454s表示垃圾收集花费的时间，last cause表示最近垃圾收集的原因
  -  Eden Space(Eden 区)：括号内的31.500M表示最大容量，9.750M表示当前容量，后面的4.362M表示当前使用情况，2313collections表示垃圾收集次数，8.458s表示垃圾收集花费时间
  - Survivor 0/Survivor 1(S0和S1区)：括号内的3.938M表示最大容量，1.188M表示当前容量，之后的值是当前使用情况
  - Old Gen(老年代)：括号内的472.625M表示最大容量，145.031M表示当前容量，之后的87.031表示当前使用情况，79collections表示垃圾收集次数 ，28.996s表示垃圾收集花费时间
  
  
3 . Histogram区域：survivor区域参数跟年龄柱状图
  - Tenuring Threshold：表示新生代年龄大于当前值则进入老年代
  - Max Tenuring Threshold：表示新生代最大年龄值
  - Desired Survivor Size：Survivor空间大小验证阙值(默认是survivor空间的一半)，用于Tenuring Threshold判断对象是否提前进入老年代。
  - Current Survivor Size：当前survivor空间大小
  - histogram柱状图：表示年龄段对象的存储柱状图
  - 当**并行新生代收集器**(-XX:+UseParallelGC|-XX:+UseParallelOldGC)和**自适应策略**功能(-XX:+UseAdaptiveSizePolicy)并用时 ，histogram柱状图不支持当前收集器
    - The Survivor Age Histogram window **not only available** when the Parallel Scagenge collection (-XX:+UseParallelGC or -XX:+AggressiveHeap) is in use.
    - JDK 1.8 默认使用 UseParallelGC 垃圾回收器，该垃圾回收器默认启动了 AdaptiveSizePolicy
    - [为什么年龄段对象存储图不显示](https://www.oracle.com/technetwork/java/visualgc-136680.html)