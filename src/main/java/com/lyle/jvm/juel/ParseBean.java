package com.lyle.jvm.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import de.odysseus.el.util.SimpleResolver;
import java.util.Date;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8
 */
public class ParseBean {

//  ${} syntax are evaluated immediately
//Deferred evaluation expressions take the form #{expr}
  public static void main(String[] args) {
    ExpressionFactory factory = new ExpressionFactoryImpl();
    SimpleContext context = new SimpleContext(new SimpleResolver());
// resolve top-level property
    factory.createValueExpression(context, "#{pi}", double.class).setValue(context, Math.PI);
    ValueExpression expr1 = factory.createValueExpression(context, "${pi/2}", double.class);
    System.out.println("pi/2 = " + expr1.getValue(context));  // pi/2 = 1.5707963267948966

// resolve bean property
    factory.createValueExpression(context, "#{current}", Date.class).setValue(context, new Date());
    ValueExpression expr2 = factory.createValueExpression(context, "${current.time}", long.class);
    System.out.println("current.time = " + expr2.getValue(context));// --> current.time = 1538048848843
  }
}