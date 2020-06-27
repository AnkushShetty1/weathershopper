package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import generic.TestUtil;

public class MoisturizersPage extends BaseTest{
	
	// List of WebElement stores all the Moisturizers name
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']")
	private List<WebElement> itemList;
	
	// List of WebElement stores all the Moisturizers price
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::p")
	private List<WebElement> priceList;
	
	// List of WebElement stores all the Moisturizers add cart button
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::button")
	private List<WebElement> addCart;
	
	// WebElement for cart icon
	@FindBy(xpath="//button[@class='thin-text nav-link']")
	private WebElement clickCart;
	
	public MoisturizersPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// This method returns low price aloe from the page
	public String getLowPriceAloe() {
		return TestUtil.getLowPriceProduct(itemList,priceList,addCart,clickCart,PRODCATEGORY_ALOE);
		
	}
	
	// This method returns low price Almond from the page
	public String getLowPriceAlmond() {
		return TestUtil.getLowPriceProduct(itemList,priceList,addCart,clickCart,PRODCATEGORY_ALMOND);
	}
	
	//This method is used to click on cart icon
	public void clickOnCart() {
		clickCart.click();
	}

}
