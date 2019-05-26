# stop the world

>1.什么是Stop the World
  + Stop the World 是JVM等待所有的用户线程进入safepoint并且阻塞，做一些全局性操作的行为
  + 所有Java代码停止，native代码可以执行，但不能与JVM交互；这些现象多半是由于gc引起
>2.进入Stop The World的原因
  + GC
  + JVM里有一条特殊的线程－－VM Threads，专门用来执行一些特殊的VM Operation，比如分派GC，thread dump等，这些任务，都需要整个Heap，以及所有线程的状态是静止的，一致的才能进行。所以JVM引入了安全点(Safe Point)的概念，想办法在需要进行VM Operation时，通知所有的线程进入一个静止的安全点。
  
>3.Stop The World的四个阶段
  + Spin(自旋)阶段。因为jvm在决定进入全局safepoint的时候，有的线程在安全点上，而有的线程不在安全点上，这个阶段是等待未在安全点上的用户线程进入安全点
  + Block阶段。即使进入safepoint，用户线程这时候仍然是running状态，保证用户线程不再继续执行，需要将用户线程阻塞 
  + sync: 等于 spin+block，这是从开始到进入安全点所耗的时间
  + Cleanup。这个阶段是JVM做的一些内部的清理工作
  + VM Operation. JVM执行的一些全局性工作，例如GC,代码反优化
  
>4.UseCountedLoopSafepoints
  + JIT编码时，会在代码中所有方法的返回之前，以及所有非counted loop的循环（无界循环）回跳之前放置一个safepoint(**counted loop则没有放置safepoint**）。GC 等操作时，需要所有线程达到safepoint  
  + 该参数可以避免GC发生时，线程因长时间运行counted loop，进入不到safepoint，而引起GC的STW时间过长
  
  
  
  