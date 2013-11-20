package com.bottle.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.appserv.jdbc.DataSource;

@Stateless
public class StatisticEJB {
	private List <UserStat> userStatList;
	
	String sel_carried_bottles_sql = "SELECT u.usr_fname, count(c.bot_unumber) FROM t_user u INNER JOIN t_user_group ug ON u.usr_id = ug.usr_id AND ug.grp_id = 2 LEFT JOIN t_carry c ON u.usr_id = c.usr_id GROUP BY u.usr_id";
	
    public List <UserStat> getTotalStat(){
    	try{
    		userStatList = new ArrayList <UserStat> ();
    		InitialContext initialContext = new InitialContext();
	    	DataSource dataSource = (DataSource)initialContext.lookup("jdbc/bottlesDB");
	    	Connection connection = dataSource.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(sel_carried_bottles_sql);
	    	
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	
	    	while (resultSet.next()){
	    		userStatList.add(new UserStat(resultSet.getString("usr_fname"), Integer.valueOf(resultSet.getString("count"))));
	    	}
	    	
	    	resultSet.close();
	    	preparedStatement.close();
	    	connection.close();
    	}
    	catch(NamingException e){
    		e.printStackTrace();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    	
    	return userStatList;
    }
}
