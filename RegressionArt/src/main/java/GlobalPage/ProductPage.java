package GlobalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage {
	
	  WebDriver driver;
	   
	   public ProductPage(WebDriver driver) {
		   this.driver = driver;
	   }
	   

	   @FindBy(id="qty")
	   WebElement quantity;

	public WebElement getQuantity() {
		return quantity;
	}
	

	   @FindBy(id="product-addtocart-button")
	   WebElement addToCart;

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	@FindBy(css="div[aria-label='M']")
	WebElement mediumTee;
	
	public WebElement getMediumTee() {
		return mediumTee;
	}
	
	@FindBy(css="div[aria-label='S']")
	WebElement smallTee;
	
	public WebElement getSmallTee() {
		return smallTee;
	}
	
	@FindBy(xpath="//*[@aria-label = 'Green']")
	WebElement greenTee;
	   
	public WebElement getGreeTee() {
		return greenTee;
	}
	
	@FindBy(xpath="//*[@aria-label = 'Yellow']")
	WebElement yellowTee;
	   
	public WebElement getYellowTee() {
		return yellowTee;
	}
	
	@FindBy(xpath="//div[@role=\"alert\"]/div[@class=\"message-success success message\"]")
	WebElement success;
	
	public WebElement getSuccess() {
		return success;
	}
	
	/*
	 * @FindBy(css = "span.counter-number") WebElement cartIcon;
	 * 
	 * public WebElement getCartIcon() { return cartIcon; }
	 */
	
	@FindBy(id="top-cart-btn-checkout")
	WebElement checkout;
	
	public WebElement getCheckout() {
		return checkout;
	}
	
	public void customizeItem(WebElement size, WebElement color, String qty) throws InterruptedException {
		size.click();
		color.click();
		getQuantity().clear();
		getQuantity().sendKeys(qty);		

		 getAddToCart().click(); 
		 Thread.sleep(5000);
		 
		 Assert.assertTrue(getSuccess().isDisplayed() ,"Product is not added to cart");
		 
	}
}
