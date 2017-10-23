package com.luckyrui.springboot.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 基础仓库接口
 *
 * @author chenrui
 * @date 2017-10-23 18:48:48
 */
@NoRepositoryBean
public interface BaseRepositoryI<T, ID extends Serializable> extends JpaRepository<T, ID> {
	List<Object> listByHql(String hql);
}
