package com.teslasales.teslasale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class TeslaSaleService 

{
	private List<TeslaSale> model3Sales = new ArrayList<TeslaSale>();
	private List<TeslaSale> modelSSales = new ArrayList<TeslaSale>();
	private List<TeslaSale> modelXSales = new ArrayList<TeslaSale>();
	
	private void readFileToList(List<TeslaSale> list, String model, String fileName)
	
	{
		BufferedReader bufferedReader = null;
		
		try
		{
			bufferedReader = new BufferedReader(new FileReader(fileName));
			bufferedReader.readLine();
			String line = null;
			String[] array;
			
			while ((line = bufferedReader.readLine()) != null)
			{
				array = line.split(",");
				list.add(new TeslaSale(model, array[0], Integer.parseInt(array[1])));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				bufferedReader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void buildList()
	{
		readFileToList(model3Sales, "Model 3", "model3.csv");
		readFileToList(modelSSales, "Model S", "modelS.csv");
		readFileToList(modelXSales, "Model X", "modelX.csv");
	}
	
	public void printReport()
	
	{
		buildList();

		System.out.println("\n\nModel 3 Yearly Sales Report");
		System.out.println("----------------------------------------");
		
		
		Map<Integer, List<TeslaSale>> model3Map = model3Sales.stream()
								.collect(Collectors.groupingBy((sale) -> YearMonth.parse(sale.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US)).getYear()));
		
		for (Map.Entry<Integer, List<TeslaSale>> entry : model3Map.entrySet())
		{
			System.out.print(entry.getKey() + " -> ");
			Integer annualSum = 0;
			annualSum = entry.getValue().stream()
							.map(sale -> sale.getNumber())
								.collect(Collectors.summingInt(Integer::intValue));
			System.out.print(annualSum + "\n");
		}

		System.out.print("\nThe best month for Model 3 was: ");
		
		TeslaSale max = model3Sales.stream()
								.max(Comparator.comparing(TeslaSale::getNumber))
									.get();
		YearMonth maxYearMonth = YearMonth.parse(max.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(maxYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));

		System.out.print("The worst month for Model 3 was: ");
		
		TeslaSale min = model3Sales.stream()
								.min(Comparator.comparing(TeslaSale::getNumber))
									.get();
		YearMonth minYearMonth = YearMonth.parse(min.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(minYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));
		
		
		System.out.println("\n\nModel S Yearly Sales Report");
		System.out.println("----------------------------------------");
		
		
		Map<Integer, List<TeslaSale>> modelSMap = modelSSales.stream()
								.collect(Collectors.groupingBy((sale) -> YearMonth.parse(sale.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US)).getYear()));
		
		for (Map.Entry<Integer, List<TeslaSale>> entry : modelSMap.entrySet())
		{
			System.out.print(entry.getKey() + " -> ");
			Integer annualSum = 0;
			annualSum = entry.getValue().stream()
							.map(sale -> sale.getNumber())
								.collect(Collectors.summingInt(Integer::intValue));
			System.out.print(annualSum + "\n");
		}

		System.out.print("\nThe best month for Model S was: ");
		
		max = modelSSales.stream()
								.max(Comparator.comparing(TeslaSale::getNumber))
									.get();
		maxYearMonth = YearMonth.parse(max.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(maxYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));

		System.out.print("The worst month for Model S was: ");
		
		min = modelSSales.stream()
								.min(Comparator.comparing(TeslaSale::getNumber))
									.get();
		minYearMonth = YearMonth.parse(min.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(minYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));
		


		System.out.println("\n\nModel X Yearly Sales Report");
		System.out.println("----------------------------------------");
		
		
		Map<Integer, List<TeslaSale>> modelXMap = modelXSales.stream()
								.collect(Collectors.groupingBy((sale) -> YearMonth.parse(sale.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US)).getYear()));
		
		for (Map.Entry<Integer, List<TeslaSale>> entry : modelXMap.entrySet())
		{
			System.out.print(entry.getKey() + " -> ");
			Integer annualSum = 0;
			annualSum = entry.getValue().stream()
							.map(sale -> sale.getNumber())
								.collect(Collectors.summingInt(Integer::intValue));
			System.out.print(annualSum + "\n");
		}

		System.out.print("\nThe best month for Model X was: ");
		
		max = modelXSales.stream()
								.max(Comparator.comparing(TeslaSale::getNumber))
									.get();
		maxYearMonth = YearMonth.parse(max.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(maxYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));

		System.out.print("The worst month for Model X was: ");
		
		min = modelXSales.stream()
								.min(Comparator.comparing(TeslaSale::getNumber))
									.get();
		minYearMonth = YearMonth.parse(min.getMonth(), DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		System.out.println(minYearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CANADA)));
		
	}

}
