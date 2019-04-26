package com.lyle.jvm.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import java.util.Arrays;
import java.util.List;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
public class OfficialDemoExtend {

  //${arrays:asList(userId,companyId);}
  public static void main(String[] args) throws Exception {
    //1.创建基本的工厂类和上下文
    ExpressionFactory factory = new ExpressionFactoryImpl();
    SimpleContext context = new SimpleContext();

    //2.设置变量值
    //函数的前缀 函数的名称 ，执行的方法  三个参数的含义
    context.setFunction("arrays", "asList", Arrays.class.getMethod("asList",Object[].class));
    context.setVariable("userId", factory.createValueExpression(101, int.class));
    factory.createValueExpression(context, "${companyId}", int.class).setValue(context, 22);

    //3.解析字符串
    ValueExpression e = factory.createValueExpression(context, "${arrays:asList(userId,companyId)}", List.class);
    System.out.println(e.getValue(context)); // --> 1


  }
}