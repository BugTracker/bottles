package com.bottle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBottleByUnumber", query = "SELECT b FROM BottleEntity b WHERE b.botUnumber = ?1"),
	@NamedQuery(name = "setBottleCarried", query = "UPDATE BottleEntity b SET b.botCarried = true WHERE b.botUnumber = ?1")
})
@Table(name = "t_bottle")
public class BottleEntity {
	
	@Temporal(TemporalType.DATE)
	@Column(name = "bot_date")
	private Date botDate;
	
	@Id
	@Column(name = "bot_unumber")
	private String botUnumber;
	
	@Column(name = "bot_carried")
	private boolean botCarried;
	
	@Column(name = "bot_finished")
	private boolean botFinished;
	
	//Getters and Setters
	public String getBotUnumber() {
		return botUnumber;
	}

	public void setBotUnumber(String botUnumber) {
		this.botUnumber = botUnumber;
	}

	public boolean getBotCarried() {
		return botCarried;
	}

	public void setBotCarried(boolean botCarried) {
		this.botCarried = botCarried;
	}

	public boolean isBotFinished() {
		return botFinished;
	}

	public void setBotFinished(boolean botFinished) {
		this.botFinished = botFinished;
	}

	public Date getBotDate() {
		return botDate;
	}

	public void setBotDate(Date botDate) {
		this.botDate = botDate;
	}
}