package com.lyle.jvm.syn;

/**
 * 疑问:线程1的"A账户"和线程2的"A账户"是同一个账户,但是为什么是同一个对象?
 * 动态的锁的顺序死锁
 */
public class DynamicOrderDeadlock {

  /**
   *
   * @param fromAccount 转出账户
   * @param toAccount 转入账户
   * @param amount 数量
   */
  public static void transferMoney(final Account fromAccount,final Account toAccount,int amount){
    synchronized (fromAccount) {
      synchronized (toAccount) {
        System.out.println(fromAccount.getName() + "--->" + toAccount.getName() + "获取到锁");
        if (fromAccount.compareTo(amount) < 0) {
          System.out.println("余额不足");
        }else {
          fromAccount.debit(amount);
          toAccount.credit(amount);
        }
      }
    }
  }


}
