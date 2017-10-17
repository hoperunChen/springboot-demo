package com.luckyrui.springboot.demo.config.test;

import com.luckyrui.springboot.demo.config.LuckyruiConfig;
import com.luckyrui.springboot.demo.config.LuckyruiConfigBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: chenrui
 * @Date: 2017/10/16 22:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoConfigApplicationTests {

	@Autowired
	private LuckyruiConfig luckyruiConfig;

	@Autowired
	private LuckyruiConfigBean luckyruiConfigBean;

	@Test
	public void testConfig() {
		Assert.assertEquals(luckyruiConfig.getName(), "陈锐");
		Assert.assertEquals(luckyruiConfig.getAge(), 18);
	}

	@Test
	public void testConfigBean() {
		Assert.assertEquals(luckyruiConfigBean.getName(), "陈锐");
		Assert.assertEquals(luckyruiConfigBean.getAge(), 18);
	}


}