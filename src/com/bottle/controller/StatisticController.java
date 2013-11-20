package com.bottle.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.bottle.ejb.StatisticEJB;
import com.bottle.ejb.UserStat;

@ManagedBean(name = "statisticController")
@RequestScoped
public class StatisticController {
	@EJB
	private StatisticEJB statisticEJB;
	
	private CartesianChartModel basicStatChart;
	private List <UserStat> userStatList;

	public StatisticController(){

	}
	
	public CartesianChartModel getBasicStatChart(){
		return basicStatChart;
	}
	
	@PostConstruct
	private void createStatisticChart(){
		userStatList = statisticEJB.getTotalStat();
		basicStatChart = new CartesianChartModel();
		ChartSeries bottles = new ChartSeries();
		bottles.setLabel("Number of Carried Bottles");
		for (int i = 0; i < userStatList.size(); i++)
			bottles.set(userStatList.get(i).getName(), userStatList.get(i).getResult());
		
		basicStatChart.addSeries(bottles);
	}
}
