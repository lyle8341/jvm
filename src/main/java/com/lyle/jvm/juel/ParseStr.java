package com.lyle.jvm.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class ParseStr {

  public static void main(String[] args) {
    //1.创建基本的工厂类和上下文
    ExpressionFactory factory = new ExpressionFactoryImpl();
    SimpleContext context = new SimpleContext();


    //2.设置变量值
    context.setVariable("var1",factory.createValueExpression("Hello",String.class));
    context.setVariable("var2",factory.createValueExpression("world",String.class));

    //3.解析字符串
    String s = "{\"argIn1\":\"${var1}\",\"argIn2\":\"${var2}\"}";
    ValueExpression e = factory.createValueExpression(context, s, String.class);
    System.out.println(e.getValue(context));
  }
}