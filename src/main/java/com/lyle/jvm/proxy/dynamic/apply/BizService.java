package com.lyle.jvm.proxy.dynamic.apply;

/**
 * 业务接口
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
public interface BizService {

  String getOpenId();

  String score(String openId);

  boolean authorized(String score);
}