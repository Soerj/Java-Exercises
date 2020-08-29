package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter rule that removes all flights from List, which has segments with
 * arrival date before departure date
 */

public class ArrivalBeforeDepartureRule implements IFilterRule
{

	@Override
	public boolean filterCondition(Segment segment)
	{
		return segment.getDepartureDate().isAfter(segment.getArrivalDate());
	}
}
