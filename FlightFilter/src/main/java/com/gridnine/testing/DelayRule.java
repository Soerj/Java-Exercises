package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DelayRule implements IFilterRule
{
	private static int DELAY_HOURS = 2;
	
	public static void setHoursGap(int gap)
	{
		if (gap > 0) DELAY_HOURS = gap;
	}
	public static int getHoursGap()
	{
		return DELAY_HOURS;
	}

	@Override
	public List<Flight> filterFlights(List<Flight> inputFlightList)
	{
		List<Flight> filteredList = new ArrayList<Flight>();

		for (Flight flight : inputFlightList)
		{
			boolean segmentRemoved = false;

			List<Segment> segments = flight.getSegments();
			if (segments.size() > 1)
			{
				for (int i = 0; i < segments.size() - 1; i++)
				{
					long delayHours = segments.get(i).getArrivalDate().until(segments.get(i + 1).getDepartureDate(), ChronoUnit.HOURS);
					if (delayHours > DELAY_HOURS)
					{
						segmentRemoved = true;
						break;
					}
				}
			}

			if (!segmentRemoved)
				filteredList.add(flight);
		}
		return filteredList;
	}

}
