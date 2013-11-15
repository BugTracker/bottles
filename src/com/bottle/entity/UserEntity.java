package com.bottle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "getUserId", query = "SELECT u.usrId FROM UserEntity u WHERE u.usrUserName = ?1")
})
@Table(name = "t_user")
public class UserEntity {
	@Id
	@Column(name = "usr_id")
	private Integer usrId;
	
	@Column(name = "usr_fname")
	private String usrFname;
	
	@Column(name = "usr_lname")
	private String usrLname;
	
	@Column(name = "usr_username")
	private String usrUserName;
	
	@Column(name = "usr_password")
	private String usrPassword;

	//Getters and Setters
	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public String getUsrFname() {
		return usrFname;
	}

	public void setUsrFname(String usrFname) {
		this.usrFname = usrFname;
	}

	public String getUsrLname() {
		return usrLname;
	}

	public void setUsrLname(String usrLname) {
		this.usrLname = usrLname;
	}

	public String getUsrUserName() {
		return usrUserName;
	}

	public void setUsrUserName(String usrUserName) {
		this.usrUserName = usrUserName;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
}
