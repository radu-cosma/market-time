package com.markettime.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markettime.entity.UserEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(UserEntity userEntity) {
		getCurrentSession().save(userEntity);
	}
}
