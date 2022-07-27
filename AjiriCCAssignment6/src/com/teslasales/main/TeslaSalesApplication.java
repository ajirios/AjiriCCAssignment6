package com.teslasales.main;

import com.teslasales.teslasale.TeslaSaleService;
/*
 * 
 * @author: Ajiri Osauzo Jeffrey (ajirios)
 * 
 */
public class TeslaSalesApplication 

{

	public static void main(String[] args) 
	
	{
		System.out.println("Welcome to the Tesla Sales Report.");
		TeslaSaleService salesService = new TeslaSaleService();
		salesService.printReport();

	}

}
