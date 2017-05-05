package com.xsc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by XSC on 2017/5/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConfigTest {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("zhangsan",applicationConfig.getName());
    }

    @Test
    public void getAge() throws Exception {
        Assert.assertEquals(new Integer(16),applicationConfig.getAge());
    }

}