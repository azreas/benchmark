package com.xzj.service;

import com.xzj.vo.User;

import java.util.List;

/**
 * @author xzj
 * @Date 2019/06/28.
 */
public interface DubboTest {
     List<User> query();

     User insert(User user);
}
