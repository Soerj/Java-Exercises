package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightFilter
{
	static List<Flight> getFilteredFlights(List<Flight> unfilteredFlights, IFilterRule... rules)
	{

		List<Flight> resultList = new ArrayList<Flight>(unfilteredFlights);

		for (IFilterRule rule : rules)
		{
			resultList = rule.filterFlights(resultList);
		}

		return resultList;

	}
}
