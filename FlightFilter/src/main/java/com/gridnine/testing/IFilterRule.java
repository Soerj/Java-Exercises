package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public interface IFilterRule
{
	default List<Flight> filterFlights(List<Flight> inputFlightList)
	{
		List<Flight> filteredList = new ArrayList<>();

		for (Flight flight : inputFlightList)
		{
			boolean segmentRemoved = false;

			for (Segment segment : flight.getSegments())
			{
				if (filterCondition(segment))
				{
					segmentRemoved = true;
					break;
				}
			}

			if (!segmentRemoved)
				filteredList.add(flight);
		}

		return filteredList;
	}

	boolean filterCondition(Segment segment);
}
