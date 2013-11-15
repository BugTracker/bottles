package com.bottle.ejb;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bottle.entity.UserEntity;

@Stateful
@RolesAllowed("admin")
public class UserEJB implements UserDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveUser(UserEntity ue){
		if (ue.getUsrId() == null){
			saveNewUser(ue);
		} 
		else{
			updateUser(ue);
		}
	}
	
	private void saveNewUser(UserEntity ue){
		entityManager.persist(ue);
	}
	
	private void updateUser(UserEntity ue){
		entityManager.merge(ue);
	}
	
	@RolesAllowed({"admin", "user"})
	public UserEntity getUser(Long ueId){
		UserEntity ue;
		ue = entityManager.find(UserEntity.class, ueId);
		return ue;
	}
	
	public void deleteUser(UserEntity ue){
		entityManager.remove(ue);
	}
}
