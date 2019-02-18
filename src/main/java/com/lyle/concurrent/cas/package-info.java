/**
 * <p>1.CAS操作需要输入两个数值，一个旧值（期望操作前的值）和一个新值，在操作期间先比较下旧值有没有发生变化，如果没有发生变化，才交换成新值，发生了变化则不交换</p>
 * <p>2.CAS主要通过compareAndSwapXXX()方法来实现，而这个方法的实现需要涉及底层的Unsafe.class类</p>
 * <p>3.java不能直接访问操作系统底层，而是通过本地方法来访问。Unsafe类提供了硬件级别的原子操作</p>
 */
package com.lyle.concurrent.cas;