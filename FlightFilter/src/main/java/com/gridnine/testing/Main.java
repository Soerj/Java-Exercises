package com.gridnine.testing;

import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		// Obtaining a test set of flights
		List<Flight> testData = FlightBuilder.createFlights(); 
		
		// Printing unfiltered list of flights
		System.out.println("unfiltered test data:");
		printData(testData);
		
		// Printing a list of flights, filtered with the first rule
		List<Flight> testData1 = FlightFilter.getFilteredFlights(testData, new BeforeCurrentMomentRule());
		System.out.println("----------------------------------");
		System.out.println("removed flights with depatrure before current moment:");
		printData(testData1);
		
		// Printing a list of flights, filtered with the second rule
		List<Flight> testData2 = FlightFilter.getFilteredFlights(testData, new ArrivalBeforeDepartureRule());
		System.out.println("----------------------------------");
		System.out.println("removed flights with arrival before departure");
		printData(testData2);
		
		// Printing a list of flights, filtered with the third rule
		List<Flight> testData3 = FlightFilter.getFilteredFlights(testData, new DelayRule());
		System.out.println("----------------------------------");
		System.out.println("removed flights with time between segments more than 2 hours");
		printData(testData3);
		
	}
	
	private static void printData(List<Flight> data)
	{
		for (Flight f : data)
		{
			System.out.println(f.toString());
		}
	}

}
