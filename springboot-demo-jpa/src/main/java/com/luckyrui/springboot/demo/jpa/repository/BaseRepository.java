package com.luckyrui.springboot.demo.jpa.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * 抽象Spring Boot Jpa实现
 *
 * @author chenrui
 * @date 2017-10-23 18:55:50
 */
public class BaseRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepositoryI<T, ID> {

	private final EntityManager entityManager;


	public BaseRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	@Override
	public List<Object> listByHql(String hql) {
		return entityManager.createQuery(hql).getResultList();
	}
}
