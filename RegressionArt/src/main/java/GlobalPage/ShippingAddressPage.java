package GlobalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {

	WebDriver driver;

	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "fieldset#customer-email-fieldset div input#customer-email")
	WebElement email;

	@FindBy(name = "firstname")
	WebElement fName;

	@FindBy(name = "lastname")
	WebElement lName;

	@FindBy(name = "street[0]")
	WebElement street;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "postcode")
	WebElement postCode;

	@FindBy(name = "country_id")
	WebElement country;

	// United Kingdom

	@FindBy(name = "telephone")
	WebElement telephone;

	@FindBy(css = "button.button.action.continue.primary")
	WebElement next;

	/*
	 * public WebDriver getDriver() { return driver; }
	 */

	@FindBy(xpath = "//input[@value='flatrate_flatrate']")
	WebElement flatRate;

	public WebElement getFlatRate() {
		return flatRate;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getfName() {
		return fName;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostCode() {
		return postCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getNext() {
		return next;
	}

	public void billingAddress() {
		getEmail().sendKeys("menakshi2023@gmail.com");

		getfName().sendKeys("Meenakshi");

		getlName().sendKeys("Thiyagarajan");

		getStreet().sendKeys("58, Ely Way");

		Select select = new Select(getCountry());

		select.selectByVisibleText("United Kingdom");

		getPostCode().sendKeys("LU4 9QN");

		getCity().sendKeys("Luton");

		getTelephone().sendKeys("7440768302");

		getFlatRate().click();
	}
}
