package com.lyle.jvm.concurrent.thread.group;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 它会保存最先结束的线程的名字
 * @author Lyle
 * @date 2019-05-08 下午3:14
 * @version v1.0
 * @since 1.8  
 */
@Getter
@Setter
@ToString
public class Result {

  private String name;
}