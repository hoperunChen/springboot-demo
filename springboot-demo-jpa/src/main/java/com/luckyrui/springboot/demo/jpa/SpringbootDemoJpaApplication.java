package com.luckyrui.springboot.demo.jpa;

import com.luckyrui.springboot.demo.jpa.repository.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenrui
 */
@EnableJpaRepositories(basePackages = {"com.luckyrui.springboot.demo.jpa"},
		repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class//指定自己的工厂类
)
@SpringBootApplication
public class SpringbootDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoJpaApplication.class, args);
	}
}
