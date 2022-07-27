package com.teslasales.teslasale;


public class TeslaSale 

{
	private String model;
	private String month;
	private Integer number;

	public TeslaSale(String model, String month, Integer number) 
	
	{
		this.model = model;
		this.month = month;
		this.number = number;
	}

	public String getModel() 
	
	{
		return model;
	}

	public void setModel(String model) 
	
	{
		this.model = model;
	}

	public String getMonth() 
	
	{
		return month;
	}

	public void setMonth(String month) 
	
	{
		this.month = month;
	}

	public Integer getNumber() 
	
	{
		return number;
	}

	public void setNumber(Integer number) 
	
	{
		this.number = number;
	}

}
