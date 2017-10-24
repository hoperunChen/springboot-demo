package com.luckyrui.springboot.demo.jpa;

import com.luckyrui.springboot.demo.jpa.repository.BaseRepositoryFactoryBean;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.ioc.spring.factory.SpringInstanceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenrui
 */
@EnableJpaRepositories(basePackages = {"com.luckyrui.springboot.demo.jpa"},
		repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class//指定自己的工厂类
)
@SpringBootApplication
public class SpringbootDemoJpaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoJpaApplication.class, args);
	}

//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
//		SpringInstanceProvider springProvider = new SpringInstanceProvider(applicationContext);
//		InstanceFactory.setInstanceProvider(springProvider);
//	}
}

