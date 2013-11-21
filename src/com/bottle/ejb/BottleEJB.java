package com.bottle.ejb;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bottle.entity.BottleEntity;
import com.bottle.entity.CarryEntity;

@Stateless
public class BottleEJB {
	@Resource
	SessionContext ctx;
	@PersistenceContext(unitName = "itBottles")
	private EntityManager em;
	
	private List <String> genUnumberList = new ArrayList <String> ();
	
	private boolean checkBottle(String curUnumber){
		Query query = em.createNamedQuery("findBottleByUnumber");
		query.setParameter(1, curUnumber);
		List <BottleEntity> bottles = query.getResultList();
		if (bottles.isEmpty())
			return false;
		else
			return true;
	}
	
	private String getBottleCode(){
		int i;
		String s;
		Random random = new Random();
		
		do{
			i = random.nextInt();
		}while(i < 0);
		s = Integer.toString(i);
		s = s.substring(0, 4);
		
		return s;
	}
	
	public void addNewBottle(BottleEntity be){
		em.persist(be);
	}
	
	public void addNewBottles(String num, Date date){
		int number = Integer.parseInt(num);
		genUnumberList.clear();
		
		for (int i = 0; i < number; i++){
				
				String newUnumber;
				
				do{
					newUnumber = getBottleCode();
				}
				while(checkBottle(newUnumber));
				
				BottleEntity bottle = new BottleEntity();
							
				bottle.setBotUnumber(newUnumber);
				bottle.setBotDate(date);
				genUnumberList.add(newUnumber);
				addNewBottle(bottle);
		}
	}
	
	public boolean carryBottle(String unum){
		Integer userId;
		Principal callerPrincipal;
		String callerName;
		boolean status = false;
		
		callerPrincipal = ctx.getCallerPrincipal();
		callerName = callerPrincipal.getName();
		
		if (checkBottle(unum)){
			status = true;
			Query query = em.createNamedQuery("getUserId");
			query.setParameter(1, callerName);
			userId = (Integer)query.getSingleResult();
			query = em.createNamedQuery("setBottleCarried");
			query.setParameter(1, unum);
			query.executeUpdate();
			CarryEntity ce = new CarryEntity();
			ce.setBotUnumber(unum);
			ce.setUsrId(userId);
			em.persist(ce);
		}
		
		return status;
	}
	
	public List <String> getNewBottlesCodeList(){
		return genUnumberList;
	}
}
