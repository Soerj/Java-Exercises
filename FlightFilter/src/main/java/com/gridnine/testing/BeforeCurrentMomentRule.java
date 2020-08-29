package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Filter rule that removes all flights from List, which has segments with
 * departure date before current moment
 */

public class BeforeCurrentMomentRule implements IFilterRule
{

	@Override
	public boolean filterCondition(Segment segment)
	{
		return LocalDateTime.now().isAfter(segment.getDepartureDate());
	}

}
