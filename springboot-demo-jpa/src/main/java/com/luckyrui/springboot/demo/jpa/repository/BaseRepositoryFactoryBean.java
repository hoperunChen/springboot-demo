package com.luckyrui.springboot.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author chenrui
 * @date
 */
public class BaseRepositoryFactoryBean<R extends JpaRepository<T, I>, T,
		I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

	public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
		return new BaseRepositoryFactory(em);
	}

	/**
	 * 创建一个内部类，该类不用在外部访问
	 * @param <T>
	 * @param <I>
	 */
	private static class BaseRepositoryFactory<T, I extends Serializable>
			extends JpaRepositoryFactory {

		private final EntityManager em;

		public BaseRepositoryFactory(EntityManager em) {
			super(em);
			this.em = em;
		}

		//设置具体的实现类是BaseRepositoryImpl
		@Override
		protected Object getTargetRepository(RepositoryInformation information) {
			return new BaseRepository<T, I>((Class<T>) information.getDomainType(), em);
		}

		//设置具体的实现类的class
		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepository.class;
		}
	}
}
