package flight;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

public class FlightBookingTestCase {

	WebDriver driver;
	private Select adult;
	private Select auto;
	By fromcity = By.id("FromTag");
	By tocity = By.id("ToTag");
	By departon = By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i");
	By datepicker = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[7]/a");
	By adults = By.id("Adults");
	By btnSearch = By.id("SearchBtn");
	By fromcitysugesstion = By.xpath("//a[contains(@id,'ui-id')]");
	By tocitysugesstion = By.id("ui-id-2");
	By roundtrip = By.id("RoundTrip");
	By todatepicker = By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[1]/a");

	By datafieldfrom = By.id("FromDate");
	By datefieldto = By.id("ReturnDate");

	public FlightBookingTestCase(WebDriver driver) {
		this.driver = driver;
	}

	public void oneWaySearch(String fromcity, String tocity) {

		commonSearch(fromcity, tocity);
		driver.findElement(this.departon).click();
		driver.findElement(this.datepicker).click();

		adult = new Select(driver.findElement(adults));
		if (adultDropDownCount() > 0) {
			adult.selectByIndex(1);
		}
		driver.findElement(this.btnSearch).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().back();

	}

	public void roundTrip(String fromcity, String tocity) {
		driver.findElement(this.roundtrip).click();
		boolean rountrip = driver.findElement(this.roundtrip).isSelected();

		if (rountrip) {
			commonSearch(fromcity, tocity);
			driver.findElement(this.departon).click();
			driver.findElement(this.datepicker).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(this.departon).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(this.departon).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(this.btnSearch).click();

		}

	}

	public void commonSearch(String fromcity, String tocity) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.fromcity));
		driver.findElement(this.fromcity).sendKeys(fromcity);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromcitysugesstion));
		driver.findElement(this.fromcitysugesstion).click();
		driver.findElement(this.tocity).sendKeys(tocity);
		WebDriverWait waits = new WebDriverWait(driver, 20);
		waits.until(ExpectedConditions.visibilityOfElementLocated(tocitysugesstion));
		driver.findElement(this.tocitysugesstion).click();

	}

	private int adultDropDownCount() {
		List<WebElement> elementCount = adult.getOptions();
		return elementCount.size();
	}

}
