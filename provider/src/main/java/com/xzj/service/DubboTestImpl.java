package com.xzj.service;

import com.xzj.service.DubboTest;
import com.xzj.vo.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author xzj
 * @Date 2019/06/28.
 */
@Service("dubboTest")
public class DubboTestImpl implements DubboTest {
    @Override
    public List<User> query() {
        return Arrays.asList(new User(1L, "account1", "password1"),
                new User(2L, "account2", "password2"),
                new User(3L, "account3", "password3"));
    }

    @Override
    public User insert(User user) {
        return user;
    }
}
