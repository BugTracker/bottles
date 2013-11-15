package com.bottle.ejb;

import javax.ejb.Remote;

import com.bottle.entity.UserEntity;

@Remote
public interface UserDao {
	public void saveUser(UserEntity ue);
	public UserEntity getUser(Long ueId);
	public void deleteUser(UserEntity ue);
}