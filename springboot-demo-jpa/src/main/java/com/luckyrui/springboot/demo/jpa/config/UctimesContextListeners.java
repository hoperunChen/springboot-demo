package com.luckyrui.springboot.demo.jpa.config;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.ioc.spring.factory.SpringInstanceProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 友创云上下文环境加载监听器<br/>
 * 主要用于集成springApplicationContext<br/>
 * spring监听器:<br/>
 * 基类:@{@link org.springframework.context.ApplicationEvent} <br>
 * 常用监听:<br/>
 * 1. ContextRefreshedEvent：当ApplicationContext初始化或者刷新时触发该事件。<br/>
 * 2. ContextClosedEvent：当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有单例Bean都被销毁。<br/>
 * 3. RequestHandleEvent: 在Web应用中，当一个http请求（request）结束触发该事件。 <br/>
 * 4. ContestStartedEvent：Spring2.5新增的事件，当容器调用ConfigurableApplicationContext的Start()方法开始/重新开始容器时触发该事件。<br/>
 * 5. ContestStopedEvent：Spring2.5新增的事件，当容器调用ConfigurableApplicationContext的Stop()方法停止容器时触发该事件。 <br/>
 *
 * @author chenrui
 * @date 2017-10-24 14:53:26
 */
@Configuration
public class UctimesContextListeners {

	/**
	 * applicationContext初始化事件
	 *
	 * @author: chenrui
	 * @date: 2017/10/24 15:12
	 */
	@Configuration
	public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
		@Override
		public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
			ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
			SpringInstanceProvider springProvider = new SpringInstanceProvider(applicationContext);
			InstanceFactory.setInstanceProvider(springProvider);
		}
	}

	/**
	 * applicationContext关闭事件
	 *
	 * @author: chenrui
	 * @date: 2017/10/24 15:12
	 */
	@Configuration
	public class ContextClosedListener implements ApplicationListener<ContextClosedEvent> {
		@Override
		public void onApplicationEvent(ContextClosedEvent contextRefreshedEvent) {
			InstanceFactory.setInstanceProvider(null);
		}
	}


}
