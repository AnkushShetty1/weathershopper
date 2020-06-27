package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IConstants{
	public static WebDriver driver;
		/*
		 * @Method Name : initialization
		 * @Description : This is the common method which initialize values(browser and url)
		 * @Param		: browser
		 * @Return		: void
		 * @Author		: Ankush Shetty
		 */
		@BeforeTest
		@Parameters("browser")
		public void initialization(@Optional ("chrome")String browser) throws Exception {
			if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty(FIRFOX_KEY, FIREFOX_VALUE);
				driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty(EDGE_KEY, EDGE_VALUE);
				driver=new EdgeDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty(IE_KEY, IE_VALUE);
				driver=new InternetExplorerDriver();
			}else if(browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}else{
				//If wrong browser passed throw exception
				throw new Exception(ERROR_MSG_BROWSER);
			}
			driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(APP_URL);
		}
		
		/*
		 * @Method Name : validateEachMethod
		 * @Description : This is the common method which checks method status after each method execution and takes screenshot if method is failed
		 * @Param		: iTestRes
		 * @Return		: void
		 * @Author		: Ankush Shetty
		 */
		@AfterMethod
		public void validateEachMethod(ITestResult iTestRes) {
			String name = iTestRes.getName();
			int status = iTestRes.getStatus();
			if(status==1) {
				Reporter.log("Test "+name+" is PASS",true);
			}
			else {
				Reporter.log("Test "+name+" is FAIL/SKIP",true);
				TestUtil.getScreenshots(IMG_PATH+name+".png");			
			}
		}
		
		/*
		 * @Method Name : exit
		 * @Description : This is the common method which which is used to close the browser at the end of execution
		 * @Param		: 
		 * @Return		: void
		 * @Author		: Ankush Shetty
		 */
		@AfterTest
		public void exit() {
			driver.close();
		}
}
