package page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BaseTest;

public class CheckoutPage extends BaseTest{
	
	// List of products added to cart
	@FindBy(xpath="//tr/td[1]")
	private List<WebElement> cartItems;
	
	// WebElement for pay button
	@FindBy(xpath="//button[@class='stripe-button-el']/span")
	private WebElement payWithCard;
	
	// WebElement for Stripe frame
		@FindBy(css="iframe.stripe_checkout_app")
		private WebElement stripeFrame;
	
	public CheckoutPage() {
		PageFactory.initElements(driver,this);
	}
	
	// This method is used verify stripe frame is displayed or not
	public boolean isFrameDisplayed() {
		return stripeFrame.isDisplayed();
	}
	
	// This method is used to switch to stripe frame
	public void switchToStripe(WebDriver driver) {
		driver.switchTo().frame(stripeFrame);
	}
	
	// This method verifies that wheteher correct products are added to cart or not
	public void verifyCart(String lp1, String lp2) {
		List<String> lowPriceItemList = new ArrayList<String>();
		lowPriceItemList.add(lp1);
		lowPriceItemList.add(lp2);
		Collections.sort(lowPriceItemList);
		List<String> cartItemList = new ArrayList<String>();
		for (int i = 0; i < cartItems.size(); i++) {
			cartItemList.add(cartItems.get(i).getText());
		}
		Collections.sort(cartItemList);
			Assert.assertEquals(cartItemList.size(), lowPriceItemList.size(),ERROR_MSG_CART);
			Assert.assertTrue(cartItemList.equals(lowPriceItemList),ERROR_MSG_CART);
			Reporter.log(SUCCESS_MSG_CART);
	}
	
	// This method is used to click on paywithcard button
	public void payWithCard() {
		payWithCard.click();
	}

}
