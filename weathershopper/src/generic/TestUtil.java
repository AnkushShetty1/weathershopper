package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class TestUtil extends BaseTest{
	static Workbook book;
	static Sheet sheet;
	
	/*
	 * @Method Name : getData
	 * @Description : This is the common method which is used to read data from excel sheet
	 * @Param		: String sheetName
	 * @Return		: Object[][] data
	 * @Author		: Ankush Shetty
	 */
	public static  Object[][] getData(String sheetName) {
			try {
				book = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
			Sheet sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			return data;
	}
	
	/*
	 * @Method Name : getLowPriceProduct
	 * @Description : This is the common method which is used to extract low price from page and add it to cart
	 * @Param		: List<WebElement> itemList,List<WebElement> priceList,List<WebElement> addCart,WebElement clickCart,String productCategory
	 * @Return		: String lowPriceItemName
	 * @Author		: Ankush Shetty
	 */
	public static String getLowPriceProduct(List<WebElement> itemList,List<WebElement> priceList,List<WebElement> addCart,WebElement clickCart,String productCategory) {
		ArrayList<Integer> selectedProdPriceList= new ArrayList<Integer>();
		for (int i = 0; i < priceList.size(); i++) {
			String item = itemList.get(i).getText();
			String priceItem = priceList.get(i).getText();
			if(item.contains(productCategory)) {
				String a1 = priceList.get(i).getText().substring(priceItem.lastIndexOf(" "),priceItem.length()).trim();
				int a2 = Integer.parseInt(a1);
				selectedProdPriceList.add(a2);
				
			}
		}
		Collections.sort(selectedProdPriceList);

		int lowPrice = selectedProdPriceList.get(0);
		String lowPriceItemName = "";
		for (int i = 0; i < priceList.size(); i++) {
			String priceItem = priceList.get(i).getText();
			String a1 = priceList.get(i).getText().substring(priceItem.lastIndexOf(" "),priceItem.length()).trim();
			int a2 = Integer.parseInt(a1);
			if(a2==lowPrice) {
				lowPriceItemName= itemList.get(i).getText();
				addCart.get(i).click();
				break;
			}
		}
		return lowPriceItemName;
	}
	
	/*
	 * @Method Name : switchToMainWindow
	 * @Description : This is the common method which is used to swich back to browser from any frame
	 * @Param		: 
	 * @Return		: void
	 * @Author		: Ankush Shetty
	 */
	public static void switchToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	/*
	 * @Method Name : getScreenshots
	 * @Description : This is the common method which is used to take screenshots
	 * @Param		: String path
	 * @Return		: void
	 * @Author		: Ankush Shetty
	 */
	public static void getScreenshots(String path) {
		TakesScreenshot t =(TakesScreenshot)driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File destFile=new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}