package hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelTestCase {
	private WebDriver driver;
	private WebDriverWait wait;

	private 

	By mHotel = By.xpath("//*[@id=\"Home\"]/div/aside[1]/nav/ul[1]/li[2]");
	By etWhere = By.id("Tags");
	By dCheckIn = By.id("CheckInDate");
	By dCheckOut = By.id("CheckOutDate");
	By dCheckinDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[1]/a");
	By dCheckoutDate=By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[2]/a");
	By submit=By.id("SearchHotelsButton");
	By wheresuggestion=By.id("ui-id-1");

	By selecttravellers=By.id("travellersOnhome");

	public HotelTestCase(WebDriver driver) {
		this.driver = driver;
	}
	
	public void findHotel(String query) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mHotel));
		driver.findElement(mHotel).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(etWhere));
		driver.findElement(etWhere).sendKeys(query);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wheresuggestion));
		driver.findElement(this.wheresuggestion).click();
		driver.findElement(dCheckIn).click();
		driver.findElement(dCheckinDate).click();
		driver.findElement(dCheckOut).click();
		driver.findElement(dCheckoutDate).click();
		Select travellers = new Select(driver.findElement(selecttravellers));
		travellers.selectByIndex(2);
		driver.findElement(submit).click();

		

	}

}
