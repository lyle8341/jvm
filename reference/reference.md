#### 四种引用

1 . 强引用(StrongReference)
  + 如果一个对象具有强引用，那垃圾回收器绝不会回收它
  + 当内存空间不足时，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题
  + 如果强引用对象不使用时，需要弱化从而使GC能够回收: strongReference = null;



2 . 软引用(SoftReference)


3 . 弱引用(WeakReference)



4 . 虚引用(PhantomReference)






















