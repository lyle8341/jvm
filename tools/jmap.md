#### jmap(JVM Memory Map)

sudo jmap -heap 17980 查看堆参数,及对各分区大小


jmap -histo 17980  查看实例数量

    Q:统计实例最多的类 前十位有哪些？ 
    A:jmap -histo pid | sort -n -r -k 2 | head -10 
    Q:统计合计容量前十的类有哪些？ 
    A：jmap -histo pid | sort -n -r -k 3 | head 10
    
    说明： 
    sort命令的部分参数含义解释如下 
    -n :使用“”纯数字”进行排序（默认是以文字类型来排序） 
    -r : 反向排序 
    -k :以那个区间（field）来进行排序的意思
    
     num     #instances         #bytes  class name
    ----------------------------------------------

 sudo jmap -clstats 6645 类加载器统计数据