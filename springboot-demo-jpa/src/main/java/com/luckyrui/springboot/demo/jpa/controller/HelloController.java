package com.luckyrui.springboot.demo.jpa.controller;

import com.luckyrui.springboot.demo.jpa.entity.User;
import com.luckyrui.springboot.demo.jpa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * hello world
 *
 * @author chenrui
 * @date 2017-09-30 14:10:44
 */
@RestController
@RequestMapping("hello")
public class HelloController {

	@Autowired
	TestRepository testRepository;

	@RequestMapping("say_hi")
	public String sayHello(){

		List<Object> users = testRepository.listByHql("select o from User o");
		System.out.println(users);
		return "hello world";
	}
}
