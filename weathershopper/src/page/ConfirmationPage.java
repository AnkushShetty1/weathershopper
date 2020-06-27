package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BaseTest;

public class ConfirmationPage extends BaseTest{
	
	//WebElement for payment_success text
	@FindBy(tagName="h2")
	private WebElement txt_confirm;
	
	//WebElement for paragraph text
	@FindBy(xpath="//p[@class='text-justify']")
	private WebElement txt_success;
	
	public ConfirmationPage() {
		PageFactory.initElements(driver,this);
	}
	
	// This metod is used to verify the success message
	public String confirmationMessage() {
		WebDriverWait wait =new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(txt_success));
		return txt_confirm.getText();
	}

}
