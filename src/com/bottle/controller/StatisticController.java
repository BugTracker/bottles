package com.bottle.controller;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "statisticController")
public class StatisticController {
	private CartesianChartModel statisticChart;
	
	public StatisticController(){
		createStatisticChart();
	}
	
	public CartesianChartModel getStatisticChart(){
		return statisticChart;
	}
	
	private void createStatisticChart(){
		statisticChart = new CartesianChartModel();
		
		ChartSeries bottles = new ChartSeries();
		bottles.setLabel("TEST");
		
		bottles.set("Aleksey", 28);
		bottles.set("Jenya", 1);
		bottles.set("Emil", 1);
		bottles.set("Arly", 3);
		bottles.set("Zarlyk", 3);
		bottles.set("Almaz", 4);
		bottles.set("Nurdin", 5);
		
		statisticChart.addSeries(bottles);
	}
}
