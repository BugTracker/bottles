package com.bottle.ejb;

public class UserStat {
	private String name;
	private Integer result;
	
	public UserStat(){
		
	}
	
	public UserStat(String name, Integer result){
		this.name = name;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
}
