package com.lyle.proxy.statics;

import com.lyle.proxy.Person;

/**
 * <p>
 *   1.实现公共接口
 *   2.持有目标类
 * </p>
 * @author Lyle
 * @date 2019-02-17 下午3:22
 * @version v1.0
 * @since 1.8  
 */
public class StudentProxy implements Person {

  private Student stu;

  public StudentProxy(Person stu){
    if(stu.getClass() == Student.class){
      //只代理学生对象
      this.stu = (Student) stu;
    }
  }

  @Override
  public void giveMoney() {
    stu.giveMoney();
  }
}