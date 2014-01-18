package com.bottle.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bottle.entity.UserEntity;

@Stateless
public class AdminEJB {
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
	
	public void saveNewUser(UserEntity ue){
		entityManager.persist(ue);
	}
	
	private void updateUser(UserEntity ue){
		entityManager.merge(ue);
	}

	public UserEntity getUser(Long ueId){
		UserEntity ue;
		ue = entityManager.find(UserEntity.class, ueId);
		return ue;
	}
	
	//raw code (need review)
	public void deleteUser(UserEntity ue){
		Query query = entityManager.createNamedQuery("selectUserIdByUsername");
		query.setParameter(1, ue.getUsrUserName());
		Long id = (Long)query.getSingleResult();
		UserEntity nue = entityManager.find(UserEntity.class, id);
		entityManager.remove(nue);
	}
	
	public List <UserEntity> getUserList(){
		Query query = entityManager.createNamedQuery("selectAllUsers");
		return query.getResultList();
	}
}
