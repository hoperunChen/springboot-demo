package com.luckyrui.springboot.demo.jpa.config;

import org.dayatang.domain.EntityRepository;
import org.dayatang.persistence.jpa.EntityRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author chenrui
 * @date
 */
@Configuration
public class DatasourceConfigJpa {

	@Bean(name = "repository")
	public EntityRepository getEntityRepository(EntityManager entityManager) {
		return new EntityRepositoryJpa(entityManager);
	}


}
