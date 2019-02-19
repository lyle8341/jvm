package com.lyle.proxy.dynamic.apply;

import org.springframework.stereotype.Service;

/**
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
@Service
public class BizServiceImpl implements BizService {

  @Override
  public String getOpenId() {
    return "201902172034123321";
  }

  @Override
  public String score(String openId) {
    return "794";
  }

  @Override
  public boolean authorized(String score) {
    return true;
  }
}