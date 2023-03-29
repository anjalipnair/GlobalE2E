package GlobalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.secondary a.action.viewcart")
	WebElement cart;

	public WebElement getCart() {
		return cart;
	}

	@FindBy(css = "input[data-role='cart-item-qty']")
	WebElement editQty;

	public WebElement getEditQty() {
		return editQty;
	}

	@FindBy(css = "button[name='update_cart_action'][type='submit']")
	WebElement updateCart;

	public WebElement getUpdateCart() {
		return updateCart;
	}
	
	 @FindBy(xpath="//td[@data-th='Order Total'] /strong/span")
	   WebElement total;
	   
	   public WebElement getTotal() {
		   return total;
	   }
	   
	   @FindBy(css=".action.action-edit")
	   WebElement editItem;
	   
	   public WebElement geteditItem() {
		   return editItem;
	   }
	   
	   @FindBy(css="tbody.cart.item strong.product-item-name a")
	   WebElement productName;
	   
	   public WebElement getProductName() {
		   return productName;
	   }
	   
	   
	   public void editCartQuantity(String qty) throws InterruptedException {
			getCart().click();
			getEditQty().clear();
			getEditQty().sendKeys(qty);		
			getUpdateCart().click();
			Thread.sleep(5000);	
	   }
}
