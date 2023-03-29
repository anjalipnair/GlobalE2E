package GlobalPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	   WebDriver driver;
	   
	   public HomePage(WebDriver driver) {
		   this.driver = driver;
	   }
	   
		
		@FindBy(id = "search")
		WebElement search;

		public WebElement getSearch() {
			return search;
		}

		@FindBy(linkText = "Gwyn Endurance Tee Medium Green")
		WebElement product1;
	
		public WebElement getProduct1() {
			return product1;
		}

		@FindBy(xpath = "//button[@type='submit']")
		WebElement addToCart;
		
		public WebElement getAddToCart() {
			return addToCart;
		}
		
		@FindBy(css="a.logo")
		WebElement logo;
		
		public WebElement getLogo() {
			return logo;
		}
		
		@FindBy(css="a.product-item-link")
		WebElement products;
		
		public WebElement getProducts() {
			return products;
		}
		
		@FindBy(css = "span.counter-number")
		WebElement cartIcon;
		
		public WebElement getCartIcon() {
			return cartIcon;
		}
		
		public void cartNavigation() {
			getLogo().click();			
			getCartIcon().click();
		}
		
}
