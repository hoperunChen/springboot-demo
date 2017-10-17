package com.luckyrui.springboot.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenrui
 * @date 2017-10-16 22:09:28
 */
@Component
@ConfigurationProperties(prefix = "com.luckyrui")
public class LuckyruiConfigBean {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
