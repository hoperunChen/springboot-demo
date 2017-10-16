package com.luckyrui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello world
 *
 * @author chenrui
 * @date 2017-09-30 14:10:44
 */
@RestController
@RequestMapping("hello")
public class HelloController {

	@RequestMapping("say_hi")
	public String sayHello(){
		return "hello world";
	}
}
