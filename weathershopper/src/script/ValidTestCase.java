package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.TestUtil;
import page.CheckoutPage;
import page.ConfirmationPage;
import page.HomePage;
import page.MoisturizersPage;
import page.PaymentPage;
import page.SunscreenPage;

public class ValidTestCase extends BaseTest {
	HomePage objHomePage;
	MoisturizersPage objMoisturizersPage;
	SunscreenPage objSunscreenPage;
	CheckoutPage objCheckoutPage;
	PaymentPage objPaymentPage;
	ConfirmationPage objConfirmationPage;
	public static String lowPriceItem1;
	public static String lowPriceItem2;
	int temperature;
    
	//Method to display temperature
	@Test(priority = 1)
	public void validGetTemp() throws InterruptedException {
		objHomePage = new HomePage(driver);
		temperature = objHomePage.getTemperature();
		Reporter.log(temperature + UNITS);
	}
    
	//Method to choose product based on temperature and add lowest price to cart
	@Test(priority = 2)
	public void validChooseProduct() {
		if (temperature < MIN_TEMP) {
			objHomePage.clickMoisturizer();
			Assert.assertEquals(driver.getTitle(), MOISTURIZERPAGETITLE);
			Reporter.log("Moisturizer is choosed");
			objMoisturizersPage = new MoisturizersPage(driver);
			lowPriceItem1 = objMoisturizersPage.getLowPriceAloe();
			lowPriceItem2 = objMoisturizersPage.getLowPriceAlmond();
			objMoisturizersPage.clickOnCart();
		} else if (temperature > MAX_TEMP) {
			objHomePage.clickSunscreen();
			Assert.assertEquals(driver.getTitle(), SUNSCREENPAGETITLE);
			Reporter.log("Sunscreen is choosed");
			objSunscreenPage = new SunscreenPage(driver);
			lowPriceItem1 = objSunscreenPage.getLowPriceSPF50();
			lowPriceItem2 = objSunscreenPage.getLowPriceSPF30();
			objSunscreenPage.clickOnCart();
		}

		Assert.assertEquals(driver.getTitle(), CARTPAGETITLE);
	}
    
	//Method to verify product added in cart page
	@Test(priority = 3)
	public void validCheckout() {
		objCheckoutPage = new CheckoutPage();
		objCheckoutPage.verifyCart(lowPriceItem1, lowPriceItem2);
		objCheckoutPage.payWithCard();
		objCheckoutPage.isFrameDisplayed();
	}
    
	//Method to get multiple data from excel
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getData(EXCEL_SHEETNAME);
		return data;
	}
    
	//Method to make card payment adding valid details
	@Test(priority = 4, dataProvider = "getTestData")
	public void validPaymentDetails(String mail, String cardNum, String expiryDate, String cvc, String zip) throws InterruptedException {
		objCheckoutPage.switchToStripe(driver);
		objPaymentPage = new PaymentPage(driver);
		objPaymentPage.setEmail(mail);
		objPaymentPage.setCardNumber(cardNum);
		objPaymentPage.setCardExpiry(expiryDate);
		objPaymentPage.setCvv(cvc);
		objPaymentPage.setZipCode(zip);
		objPaymentPage.clickPay();
		TestUtil.switchToMainWindow();
	}
	
	//Method to verify payment successfull or not
	@Test(priority=5)
	public void verifyConfirmMessage()  {
		objConfirmationPage=new ConfirmationPage();
			Assert.assertEquals(objConfirmationPage.confirmationMessage(), "PAYMENT SUCCESS",ERROR_MSG_CONFIRMATION);;
			Reporter.log(SUCCESS_MSG_CONFIRMATION);
	}

}
