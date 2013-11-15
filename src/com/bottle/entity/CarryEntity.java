package com.bottle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="t_carry")
public class CarryEntity {
	/*@Temporal(TemporalType.DATE)
	@Column(name = "car_datetime")
	private Date carDate;*/
	
	@Id
	@Column(name = "bot_unumber")
	private String botUnumber;

	@Column(name = "usr_id")
	private Integer usrId;

	//Getters and Setters
	/*public Date getCarDate() {
		return carDate;
	}

	public void setCarDate(Date carDate) {
		this.carDate = carDate;
	}*/

	public String getBotUnumber() {
		return botUnumber;
	}

	public void setBotUnumber(String botUnumber) {
		this.botUnumber = botUnumber;
	}

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
}
