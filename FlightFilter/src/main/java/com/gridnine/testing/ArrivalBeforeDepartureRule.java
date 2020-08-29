package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDepartureRule implements IFilterRule
{
	
	@Override
	public List<Flight> filterFlights(List<Flight> inputFlightList)
	{
		List<Flight> filteredList = new ArrayList<Flight>();
		
		for (Flight flight : inputFlightList)
		{
			boolean segmentRemoved = false;
			
			for (Segment segment : flight.getSegments())
			{
				if (segment.getDepartureDate().isAfter(segment.getArrivalDate()))
				{
					segmentRemoved = true;
					break;
				}
			}
			
			if (!segmentRemoved) filteredList.add(flight);
		}
		return filteredList;
	}

}
