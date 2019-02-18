package com.lyle.proxy.dynamic.apply;

/**
 * 业务接口
 * @author Lyle
 * @date 2019-02-17 下午8:28
 * @version v1.0
 * @since 1.8  
 */
public interface BizService {

  String getOpenId();

  String score(String openId);

  boolean authorized(String score);
}