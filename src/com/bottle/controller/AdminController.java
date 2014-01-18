package com.bottle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bottle.ejb.AdminEJB;
import com.bottle.entity.UserEntity;

@ManagedBean(name = "adminController")
@RequestScoped
public class AdminController {
	@EJB
	private AdminEJB adminEJB;
	
	private UserEntity user = new UserEntity();
	private UserEntity selectedUser = new UserEntity();
	private List <UserEntity> userList = new ArrayList <UserEntity> ();
	
	public void doCreateNewUser(){
		adminEJB.saveNewUser(user);
	}
	
	public void doDeleteUser(){
		adminEJB.deleteUser(selectedUser);
	}
	
	public void setUser(UserEntity user){
		this.user = user;
	}
	
	public UserEntity getUser(){
		return user;
	}
	
	public void setSelectedUser(UserEntity selectedUser){
		this.selectedUser = selectedUser;
	}
	
	public UserEntity getSelectedUser(){
		return selectedUser;
	}

	public List <UserEntity> getUserList(){
		userList = adminEJB.getUserList();
		return userList;
	}
}
