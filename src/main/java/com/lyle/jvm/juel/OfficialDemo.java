package com.lyle.jvm.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
public class OfficialDemo {

  //${math:max(foo,bar)}
  public static void main(String[] args) throws Exception {

    //1.创建基本的工厂类和上下文
    ExpressionFactory factory = new ExpressionFactoryImpl();
    SimpleContext context = new SimpleContext();

    //2.设置变量值
    //函数的前缀 函数的名称 ，执行的方法  三个参数的含义
    context.setFunction("math", "max", Math.class.getMethod("max", int.class, int.class));
    context.setVariable("foo", factory.createValueExpression(0, int.class));
    factory.createValueExpression(context, "${bar}", int.class).setValue(context, 1);

    //3.解析字符串
    ValueExpression e = factory.createValueExpression(context, "${math:max(foo,bar)}", int.class);
    System.out.println(e.getValue(context)); // --> 1


  }
}