# jvm
summary jvm

+ java启动参数
   1. 标准参数(-),所有的JVM实现都必须实现这些参数的功能，而且向后兼容；
   2. 非标准参数(-X),默认jvm实现这些参数的功能，但是并不保证所有jvm实现都满足，且不保证向后兼容；
   3. 非Stable参数(-XX),此类参数各个jvm实现会有所不同，将来可能会随时取消，需要慎重使用；

+ 查看jvm参数

      sudo jinfo -flags 5670
      sudo jmap -heap 8842
      jcmd 5670 VM.flags
      jcmd 2209 help
      
      

  ```jvm
  -XX:CICompilerCount=3 
  -XX:InitialHeapSize=197132288 
  -XX:MaxHeapSize=3128950784 
  -XX:MaxNewSize=1042808832 
  -XX:MinHeapDeltaBytes=524288 
  -XX:NewSize=65536000 
  -XX:OldSize=131596288 
  -XX:+UseCompressedClassPointers 
  -XX:+UseCompressedOops 
  -XX:+UseFastUnorderedTimeStamps 
  -XX:+UseParallelGC
  ```