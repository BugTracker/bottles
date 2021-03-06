package com.bottle.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
	
	public  void doAddNewBottles(){
		bottleEJB.addNewBottles(quantity, date);
		newUniqueBottlesCodeList = bottleEJB.getNewBottlesCodeList();
	}
	
	public void doCarryBottle(ActionEvent actionEvent){
		if(bottleEJB.carryBottle(unumber))
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
																			 "INFO:",
																			 "The bottle has been succesfully carried"));
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					 "WARN:",
					 "There's no bottle with such code"));
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
}
