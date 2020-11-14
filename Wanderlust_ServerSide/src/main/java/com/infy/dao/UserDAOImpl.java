package com.infy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.UserEntity;
import com.infy.model.Users;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Users getUserByUserId(Integer userId) throws Exception {
		Users user = null;
		UserEntity userEntity = entityManager.find(UserEntity.class, userId);
		if (userEntity != null) {
			user = new Users();
			user.setUserId(userEntity.getUserId());
			user.setUserName(userEntity.getUserName());
			user.setEmailId(userEntity.getEmailId());
			user.setContactNumber(userEntity.getContactNumber());
			user.setPassword(userEntity.getPassword());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getUserByContactNumber(String contactNumber) throws Exception {
		Query query = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.contactNumber = :contactNumber");
		query.setParameter("contactNumber", contactNumber);
		Users user = null;
		List<UserEntity> userEntities = query.getResultList();
		if (!userEntities.isEmpty()) {
			UserEntity userEntity = userEntities.get(0);
			user = new Users();
			user.setUserId(userEntity.getUserId());
			user.setEmailId(userEntity.getEmailId());
			user.setContactNumber(userEntity.getContactNumber());
			user.setUserName(userEntity.getUserName());
			user.setPassword(userEntity.getPassword());
		}
		return user;
	}
	
	@Override
	public Users registerUser(Users user) throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(user.getUserName());
		userEntity.setEmailId(user.getEmailId());
		userEntity.setContactNumber(user.getContactNumber());
		userEntity.setPassword(user.getPassword());
		entityManager.persist(userEntity);
		user.setUserId(userEntity.getUserId());
		return user;
	}
}
