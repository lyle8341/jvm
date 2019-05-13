package com.lyle.jvm.syn;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private int balance = 1000;//这里假设每个人账户里面初始化的钱
    private final int accNo;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    private String name;

    private static final AtomicInteger sequence = new AtomicInteger();
    
    public Account() {
      accNo = 1;//sequence.incrementAndGet();
    }

    void debit(int m) {
      Pause.sleep(5000);//模拟操作时间
      balance = balance + m;
    }
    
    void credit(int m) {
      Pause.sleep(5);//模拟操作时间
      balance = balance - m;
    } 
    
    int getBalance() {
      return balance;
    }
    
    int getAccNo() {
      return accNo;
    }
    
    public int compareTo(int money) {
      return Integer.compare(balance, money);
    }

    @Override
    public String toString() {
      return "Account{" +
          "balance=" + balance +
          ", accNo=" + accNo +
          ", name='" + name + '\'' +
          '}';
    }

  /*@Override
  public boolean equals(Object o) {
    System.out.println("equals invoked");
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return balance == account.balance &&
        accNo == account.accNo &&
        Objects.equals(name, account.name);
  }

  @Override
  public int hashCode() {
    System.out.println("hashcode invoked");
    return Objects.hash(balance, accNo, name);
  }*/
}