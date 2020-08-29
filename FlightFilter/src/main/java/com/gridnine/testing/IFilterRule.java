package com.gridnine.testing;

import java.util.List;

public interface IFilterRule
{
	List<Flight> filterFlights(List<Flight> inputFlightList);
}
