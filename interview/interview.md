#### interview

* Map
  - HashMap
   
        hashMap.put(null,null);
        hashMap.put(null,null);
        hashMap.put(null,null);
        结果:{null=null}
    - 线程不安全
    - Collections.synchronizedMap(HashMap map)使其具有同步功能
  - HashTable
    - 它不允许记录的键或者值为空
    - 线程安全
  - TreeMap
    - TreeMap能够把它保存的记录根据键排序，默认是按升序排序
    - TreeMap的键和值都不能为空
  - LinkedHashMap
    - 保存了记录的插入顺序
* HashSet 的实现原理
  - 底层是个map
  - map.put(e, PRESENT)   
* ArrayList&LinkedList
  - ArrayList基于动态数组，根据下表随机访问数组元素的效率高，向数组尾部添加元素的效率高
  - LinkedList基于链表，数据添加删除效率高

* ArrayList&Vector
  - Vector的方法都是同步的,线程安全的

* Array&ArrayList
  - Array可以包含基本类型和对象类型，ArrayList只能包含对象类型
  - Array大小固定，ArrayList的大小是动态变化的
  - ArrayList提供了更多的方法和特性

* Queue方法比较

  |	  抛异常  	|	 false/null 	|
  |:---------:|:-------------:|
  |   add     |     offer     |
  |  remove   |     poll      |
  |  element  |     peak      |


* 抽象类
  - 抽象类可以没有抽象方法
  - 如果抽象类有抽象方法,其子类要么实现抽象方法,要么也必须是抽象类
  
* Collection 和 Collections 有什么区别
  - java.util.Collection 是一个集合接口,List，Set，Queue接口都继承Collection
  - java.util.Collections 是一个包装类,它包含有各种有关集合操作的静态方法,此类不能实例化，工具类/帮助类
  - Collections 不属于java的集合框架的
  
  
  
* 怎么确保一个集合不能被修改
  - Collections.unmodifiablexx
  
        add(int index, E element) {
          throw new UnsupportedOperationException();
        }
        public V put(K key, V value) {
          throw new UnsupportedOperationException();
        }
        ...
  - 不是真正的不可变.只是不允许通过不可变引用去修改原集合,但是可以直接修改原集合
  - Guava Immutable真正不可变,复制了一份,并不是直接操作原集合z


* 线程的状态
  - 新建-->就绪-->运行-->阻塞-->死亡
  
* notifyAll&notify
  - notifyAll()方法（唤醒所有 wait 线程）
  - notify()方法（只随机唤醒一个 wait 线程）
  
* synchronized和lock  
  - synchronized是基于jvm底层实现的数据同步，lock是基于Java编写，主要通过硬件依赖CPU指令实现数据同步
  
* spring 中的 bean 是线程安全的吗  ???
  
  
* MyBatis缓存
  - 默认支持一级缓存,不需要另外配置,但是在跟 spring 整合的时候,进行 mapper 代理开发的方式时,mybatis 的一级缓存是不存在的 ,因为代理模板每次调用完之后都会关闭sqlSession.  
  - 一个service方法中包括很多Mapper方法调用,事务控制在service中,可以有一级缓存,因为这里的sqlSession开始执行时打开,最后关闭
  - 如果 sqlSession 里面出现 commit 操作, sqlSession 中的缓存会被全部清空,避免出现脏读.  
  
  