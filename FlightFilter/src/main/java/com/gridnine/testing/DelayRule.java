package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * Filter rule that removes all flights from List, which has segments with delay
 * between arrival and departure longer than delayHours
 */

public class DelayRule implements IFilterRule
{
	private int delayHours;

	public int getDelayHours()
	{
		return delayHours;
	}

	public DelayRule()
	{
		delayHours = 2;
	}

	public DelayRule(int delayHours)
	{
		if (delayHours > 0)
		{
			this.delayHours = delayHours;
		}
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
					long delayHours = segments.get(i).getArrivalDate().until(segments.get(i + 1).getDepartureDate(),
							ChronoUnit.HOURS);
					if (delayHours > this.delayHours)
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

	@Override
	public boolean filterCondition(Segment segment)
	{
		throw new NotImplementedException();
	}
}
