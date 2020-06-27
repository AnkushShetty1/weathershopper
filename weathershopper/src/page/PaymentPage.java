package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.BaseTest;

public class PaymentPage extends BaseTest{
	
	//WebElement for email id textfield
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	//WebElement for cardnumber id textfield
	@FindBy(css="div[class='StaggerGroup-child is-head-1 is-tail-NaN'] input")
	private WebElement cardNumber;
	
	//WebElement for cardexpiry id textfield
	@FindBy(xpath="//input[@placeholder='MM / YY']")
	private WebElement cardExpiry;
	
	//WebElement for cvv id textfield
	@FindBy(xpath="//input[@placeholder='CVC']")
	private WebElement cvv;
	
	//WebElement for zipcode id textfield
	@FindBy(xpath="//input[@placeholder='ZIP Code']")
	private WebElement zipCode;
	
	//WebElement for pay button
	@FindBy(xpath="//div[@class='Section-button']/button")
	private WebElement payButton;
	
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//set email id
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	//set card number
	public void setCardNumber(String cardNum) {
		cardNumber.sendKeys(cardNum);
	}
	
	//set card expiry
	public void setCardExpiry(String expiryDate) {
		cardExpiry.sendKeys(expiryDate);
	}
	
	//set cvv
	public void setCvv(String cvvValue) {
		cvv.sendKeys(cvvValue);
	}
	
	//set zipcode
	public void setZipCode(String zip) {
		zipCode.sendKeys(zip);
	}
	
	//click pay button
	public void clickPay() {
		payButton.click();
	}

}
