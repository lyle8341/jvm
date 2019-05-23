# stop the world

>1.什么是Stop the World
  + Stop the World 是JVM等待所有的用户线程进入safepoint并且阻塞，做一些全局性操作的行为
  
>2.进入Stop The World的原因
  + xx
  
>3.Stop The World的四个阶段
  + Spin(自旋)阶段。因为jvm在决定进入全局safepoint的时候，有的线程在安全点上，而有的线程不在安全点上，这个阶段是等待未在安全点上的用户线程进入安全点
  + Block阶段。即使进入safepoint，用户线程这时候仍然是running状态，保证用户线程不再继续执行，需要将用户线程阻塞 
  + sync: 等于 spin+block，这是从开始到进入安全点所耗的时间
  + Cleanup。这个阶段是JVM做的一些内部的清理工作
  + VM Operation. JVM执行的一些全局性工作，例如GC,代码反优化
  
  
  
  
  
  