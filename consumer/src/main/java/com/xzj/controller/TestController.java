package com.xzj.controller;

import com.xzj.service.DubboTest;
import com.xzj.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by charles on 2017/5/25.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DubboTest dubboTest;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        String result = restTemplate.getForObject("http://127.0.0.1:5080/user", String.class);
        return result;
    }

    @RequestMapping("/query")
    public List<User> queryTest() {
        return dubboTest.query();
    }

}
