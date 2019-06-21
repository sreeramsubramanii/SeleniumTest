package hotel;

import org.testng.annotations.Test;

import Test.TestVagrant.BaseClass;

public class HotelTestFunctions extends BaseClass {
	
	@Test
	public void veriyHotelBooking()
	{
		HotelTestCase findHotel=new HotelTestCase(driver);
		findHotel.findHotel("Coimbatore");
	}

}
