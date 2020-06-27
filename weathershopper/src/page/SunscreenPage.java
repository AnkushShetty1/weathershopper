package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BaseTest;
import generic.TestUtil;

public class SunscreenPage extends BaseTest{
	
	// List of WebElement stores all the Sunscreen name
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']")
	private List<WebElement> itemList;
	
	// List of WebElement stores all the Sunscreen price
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::p")
	private List<WebElement> priceList;
	
	// List of WebElement stores all the Sunscreen add cart button
	@FindBy(xpath="//p[@class='font-weight-bold top-space-10']/following-sibling::button")
	private List<WebElement> addCart;
	
	// WebElement for cart icon
	@FindBy(xpath="//button[@class='thin-text nav-link']")
	private WebElement clickCart;
	
	public SunscreenPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// This method returns low price SPF50 from the page
	public String getLowPriceSPF50() {
		return TestUtil.getLowPriceProduct(itemList,priceList,addCart,clickCart,PRODCATEGORY_SPF50);
	}
	
	// This method returns low price SPF30 from the page
	public String getLowPriceSPF30() {
		return TestUtil.getLowPriceProduct(itemList,priceList,addCart,clickCart,PRODCATEGORY_SPF30);
	}
	
	//This method is used to click on cart icon
	public void clickOnCart() {
		clickCart.click();
	}

}

