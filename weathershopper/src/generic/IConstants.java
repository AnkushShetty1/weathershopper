package generic;

public interface IConstants {
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./driver/chromedriver.exe";
	String FIRFOX_KEY="webdriver.gecko.driver";
	String FIREFOX_VALUE="./driver/geckodriver.exe";
	String IE_KEY="webdriver.ie.driver";
	String IE_VALUE="./driver/IEDriverServer.exe";
	String EDGE_KEY="webdriver.edge.driver";
	String EDGE_VALUE="./driver/msedgedriver.exe";
	String APP_URL="http://weathershopper.pythonanywhere.com/";
	String EXCEL_PATH="./data/input.xlsx";
	String EXCEL_SHEETNAME = "PaymentDetails";
	String IMG_PATH="./screenshots/";
	String MOISTURIZERPAGETITLE="The Best Moisturizers in the World!";
	String SUNSCREENPAGETITLE="The Best Sunscreens in the World!";
	String CARTPAGETITLE="Cart Items";
	String PRODCATEGORY_ALOE="Aloe";
	String PRODCATEGORY_ALMOND="Almond";
	String PRODCATEGORY_SPF50="SPF-50";
	String PRODCATEGORY_SPF30="SPF-30";
	String ERROR_MSG_CONFIRMATION="Payment is not successfull";
	String SUCCESS_MSG_CONFIRMATION="Payment is successfull";
	String ERROR_MSG_BROWSER="Browser is not correct";
	String ERROR_MSG_CART="Wrong products added to cart";
	String SUCCESS_MSG_CART="Cart products are matching correctly";
	String UNITS = " °C";
	int MIN_TEMP=19;
	int MAX_TEMP=34;
	long IMPLICIT_TIMEOUT=10;
	long EXPLICIT_TIMEOUT=8;
}
