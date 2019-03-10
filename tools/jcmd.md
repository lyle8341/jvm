#### jcmd

|		         		命令           			|          					        	  描述			  			  		             	|
|:---------------------------------:|:-----------------------------------------------------------------:|
|jcmd PID VM.uptime           			|	查看JVM的启动时长													                          |
|jcmd PID GC.class_histogram       	|	查看JVM的类信息，这个可查看每个类的实例数量和占用空间大小。				          	|
|jcmd PID Thread.print     		    	|	查看JVM的Thread Dump 											                        	|
|jcmd PID GC.heap_dump FILE_NAME    |	查看JVM的Heap Dump,注意，如果只指定文件名，默认会生成在启动 JVM 的目录里。	  |
|jcmd PID VM.system_properties     	|	查看JVM的属性信息													                          |
|jcmd PID VM.flags     			      	|	查看JVM的启动参数,注意，可以看到 -X 和 -XX 的参数信息		            			|
|jcmd PID VM.command_line       		|	查看JVM的启动命令行												                          	|
|jcmd PID GC.run_finalization 	  	|	对JVM执行System.runFinalization(),尽量别去调用这个对象的finalize方法。 	|
|jcmd PID GC.run 				          	|	对JVM执行System.gc()											                        	|
|jcmd PID PerfCounter.print		    	| 查看JVM的性能												                            		|