package flight;

import org.testng.annotations.Test;
import Test.TestVagrant.BaseClass;

public class FlightFunctionality extends BaseClass {

	@Test(priority = 0)
	public void verifyFlightSearch()

	{
		FlightBookingTestCase bookingTestCase = new FlightBookingTestCase(driver);


		bookingTestCase.oneWaySearch("chennai", "coimbatore");
	}
	
	@Test(priority = 1)
	public void verifyRoundTtrip()
	{
		FlightBookingTestCase bookingTestCase = new FlightBookingTestCase(driver);

		bookingTestCase.roundTrip("chennai", "coimbatore");
	}

	

}
