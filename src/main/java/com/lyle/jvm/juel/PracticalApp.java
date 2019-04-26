package com.lyle.jvm.juel;

import com.lyle.jvm.juel.bean.GenerateRandom;
import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import de.odysseus.el.util.SimpleResolver;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * 实战应用
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class PracticalApp {

  public static void main(String[] args){
    test("${gr.generate()}");

  }


  private static void test(String expression) {
    ExpressionFactory factory = new ExpressionFactoryImpl();
    SimpleContext context = new SimpleContext(new SimpleResolver());
// resolve top-level property
    factory.createValueExpression(context, "#{gr}", GenerateRandom.class).setValue(context, new GenerateRandom());
    ValueExpression e = factory.createValueExpression(context, expression, int.class);
    System.out.println("gr.generate() = " + e.getValue(context));

  }
}