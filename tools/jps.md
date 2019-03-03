#### jps 原理(JVM Process Status)

+ jdk中的jps命令可以显示当前运行的java进程以及相关参数，它的实现机制如下：
  * java程序在启动以后，会在java.io.tmpdir指定的目录下，就是临时文件夹里，生成一个类似于hsperfdata_User的文件夹，这个文件夹里（在Linux中为/tmp/hsperfdata_{userName}/），有几个文件，名字就是java进程的pid，因此列出当前运行的java进程，只是把这个目录里的文件名列一下而已。 至于系统的参数什么，就可以解析这几个文件获得。
  * hsperfdata:HotSpot Performance data log
  * jps -m  #传递给main 方法的参数
  * jps -l  #application的主类的全包名，或jar的全路径
  * jps -v  #传递给jvm的参数
  
  
  
  
  http://www.51niux.com/?id=219