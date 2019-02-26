package com.lyle.jvm.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public class StackTest {

  @Test
  public void whenStackIsCreated_thenItHasSize0(){
    Stack<Integer> integerStack = new Stack<>();
    System.out.println(integerStack.capacity());
    assertEquals(0,integerStack.size());
  }

  @Test
  public void whenElementIsPushed_thenStackSizeIsIncreased() {
    Stack<Integer> intStack = new Stack<>();
    intStack.push(1);

    assertEquals(1, intStack.size());
  }

  @Test
  public void whenMultipleElementsArePushed_thenStackSizeisIncreased() {
    Stack<Integer> intStack = new Stack<>();
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10,11);
    boolean result = intStack.addAll(intList);

    assertTrue(result);
    assertEquals(11, intList.size());
    System.out.println("init capacity:"+ intStack.capacity());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.pop());
    System.out.println(intStack.size());
    System.out.println("after capacity:"+ intStack.capacity());
  }

  @Test
  public void whenElementIsPoppedFromStack_thenSizeChanges() {
    Stack<Integer> intStack = new Stack<>();
    intStack.push(5);
    intStack.pop();

    assertTrue(intStack.isEmpty());
  }


  @Test
  public void whenElementIsOnStack_thenIndexOfReturnsItsIndex() {
    Stack<Integer> intStack = new Stack<>();
    intStack.push(5);
    intStack.push(6);
    intStack.push(7);
    int indexOf = intStack.indexOf(5);
    assertEquals(0, indexOf);
    int indexOf1 = intStack.indexOf(6);
    assertEquals(1, indexOf1);
  }
}