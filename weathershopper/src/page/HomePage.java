package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//WebElement for temperature
	@FindBy(id="temperature")
	private WebElement temperature;
	
	// WebElement for moisturizer link
	@FindBy(xpath="//a[@href='/moisturizer']/button")
	private WebElement moisturizer;
	
	// WebElement for sunscreen link
	@FindBy(css="a[href='/sunscreen'] button")
	private WebElement sunscreen;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	// This method is used to return temerature value
	public int getTemperature() {
		String[] temp = temperature.getText().split(" ");
		int intTemp = Integer.parseInt(temp[0]);
		return intTemp;
	}
	
	// This method is used to click on Moisturizer link 
	public void clickMoisturizer() {
		moisturizer.click();
	}
	
	// This method is used to click on Sunscreen link 
	public void clickSunscreen() {
		sunscreen.click();
	}

}
