package com.bottle.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bottle.ejb.BottleEJB;
import com.bottle.entity.BottleEntity;

@ManagedBean(name = "bottleController")
@RequestScoped
public class BottleController {
	@EJB
	private BottleEJB bottleEJB;
	
	private String quantity;
	private Date date;
	private String unumber;
	private List <String> newUniqueBottlesCodeList = new ArrayList <String> ();
	
	private BottleEntity bottle = new BottleEntity();
	
	public  String doAddNewBottles(){
		bottleEJB.addNewBottles(quantity, date);
		newUniqueBottlesCodeList = bottleEJB.getNewBottlesCodeList();
		return "listnumber.xhtml";
	}
	
	public void doCarryBottle(){
		bottleEJB.carryBottle(unumber);
	}
	
	public BottleEntity getBottle() {
        return bottle;
    }

    public void setBottle(BottleEntity bottle) {
        this.bottle = bottle;
    }

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public List<String> getNewUniqueBottlesCodeList() {
		return newUniqueBottlesCodeList;
	}

	public void setNewUniqueBottlesCodeList(List<String> newUniqueBottlesCodeList) {
		this.newUniqueBottlesCodeList = newUniqueBottlesCodeList;
	}
}
