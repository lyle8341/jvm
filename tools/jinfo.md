#### jinfo

    jinfo -flag name pid==>查看VM options参数默认值或者指定值
      jcmd 5670 VM.flags
      jinfo -flag UseParallelGC  17980
      jinfo -flag UseAdaptiveSizePolicy 17980
    
    jinfo -flag +PrintGC 43520
    jinfo -flag +PrintGCDetails 43520
    
    jinfo -flag -PrintGC 43520
    jinfo -flag -PrintGCDetails 43520
    
    jinfo -flag key=value