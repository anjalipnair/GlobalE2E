package GlobalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {
	
	 WebDriver driver;
	   
	   public PaymentPage(WebDriver driver) {
		   this.driver = driver;
	   }
	   
	   @FindBy(css="div.billing-address-details")
	   WebElement billingAddress;
	   
	   public WebElement getBillingAddress() {
		   return billingAddress;
	   }

	   @FindBy(xpath="//td[@data-th='Order Total'] /strong/span")
	   WebElement total;
	   
	   public WebElement getTotal() {
		   return total;
	   }
	   
	   @FindBy(css="tr.totals.sub td span")
	   WebElement subTotal;
	   
	   public WebElement getSubTotal() {
		   return subTotal;
	   }
}
