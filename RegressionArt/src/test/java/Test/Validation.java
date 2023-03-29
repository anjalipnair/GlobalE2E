package Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import GlobalBase.Base;
import GlobalPage.CartPage;
import GlobalPage.HomePage;
import GlobalPage.PaymentPage;
import GlobalPage.ProductPage;
import GlobalPage.ShippingAddressPage;

public class Validation {

	WebDriver driver;
	HomePage homePg;
	ProductPage productPg;
	ShippingAddressPage shipppingPg;
	PaymentPage paymentPg;
	CartPage cartPg;
	JavascriptExecutor js;

	@org.testng.annotations.BeforeClass
	public void BeforeClass() throws IOException {
		driver = Base.openBrowser();
		homePg = PageFactory.initElements(driver, HomePage.class);
		productPg = PageFactory.initElements(driver, ProductPage.class);
		shipppingPg = PageFactory.initElements(driver, ShippingAddressPage.class);
		paymentPg = PageFactory.initElements(driver, PaymentPage.class);
		cartPg = PageFactory.initElements(driver, CartPage.class);
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void sample() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		searchItems("Gwyn Endurance Tee");
		productPg.customizeItem(productPg.getMediumTee(), productPg.getGreeTee(), "04");
		homePg.getCartIcon().click();
		productPg.getCheckout().click();
		
		shipppingPg.billingAddress();
		js.executeScript("arguments[0].click();", shipppingPg.getNext());
		
		//Validating billing address and total at payment page
		Assert.assertTrue(paymentPg.getBillingAddress().getText().contains("United Kingdom"), "Address is not UK Address");
		Assert.assertTrue(paymentPg.getTotal().getText().contains("$92.00"), "Total is not as expected");

		//Updating the quantity of the cart item
		homePg.cartNavigation();
		cartPg.editCartQuantity("03");
		
		//Adding different size for the same product
		cartPg.getProductName().click();
		Thread.sleep(5000);
		productPg.customizeItem(productPg.getSmallTee(), productPg.getYellowTee(), "01");

		//Adding new item to cart
		searchItems("Quest Lumaflex™ Band");
		productPg.getAddToCart().click();
		Assert.assertTrue(productPg.getSuccess().isDisplayed(), "Product is not added to cart");

		homePg.getCartIcon().click();
		productPg.getCheckout().click();

		js.executeScript("arguments[0].click();", shipppingPg.getNext());
		
		/*
		 * Item sub-total comes to 116 and not 115. Including flat rate for shipping its 25 and totals to 140
		 * Tried to edit shipping method but only flat rate is still available.
		 * Not sure how to get the discount applied
		 */

		Assert.assertTrue(paymentPg.getSubTotal().getText().contains("$115.00"), "Order subtotal works as expected");

		System.out.println("Items were added to cart successfully");
	}

	@AfterClass
	public void teadDown() {
		driver.close();
		driver.quit();
	}

	public void searchItems(String itemName) {
		homePg.getSearch().sendKeys(itemName + Keys.ENTER);
		List<WebElement> products = driver.findElements(By.cssSelector("a.product-item-link"));
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().trim().equals(itemName)) {
				products.get(i).click();
				break;
			}
		}
	}
}
