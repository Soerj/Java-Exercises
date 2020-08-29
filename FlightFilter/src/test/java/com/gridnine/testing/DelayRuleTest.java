package com.gridnine.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DelayRuleTest
{

	@Test
	void test()
	{
		List<Flight> testData = FlightBuilder.createFlights();
		List<Flight> expected = new ArrayList<Flight>(FlightBuilder.createFlights());
		expected.remove(4);
		assertEquals(expected.toString(), FlightFilter.getFilteredFlights(testData, new DelayRule()).toString());
	}

}
