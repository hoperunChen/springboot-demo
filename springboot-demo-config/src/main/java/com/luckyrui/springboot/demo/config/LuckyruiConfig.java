package com.luckyrui.springboot.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chenrui
 * @date 2017-10-16 22:09:28
 */
@Component
public class LuckyruiConfig {

	@Value("${com.luckyrui.name}")
	private String name;

	@Value("${com.luckyrui.age}")
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
