package com.luckyrui.springboot.demo.jpa.service;

import com.luckyrui.springboot.demo.jpa.entity.User;
import org.dayatang.domain.Entity;
import org.dayatang.domain.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author chenrui
 * @date
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {

	@Autowired
	EntityRepository entityRepository;

	@Override
	public void testMethod() {
		User u = new User("chenrui");
		u.setId(UUID.randomUUID().toString());
		u.setVersion(0);
		entityRepository.save((Entity) u);
	}
}
