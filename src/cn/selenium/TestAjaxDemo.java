package cn.selenium;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestAjaxDemo {
	public static WebDriver driver;
	String url = "http://sogou.com";

	@Test
	public void testDemo() {
		driver.get(url);
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("wrap")).click();
		WebElement element = driver.findElement(By.id("query"));

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		element.click();
		/*
		 * 
		 * 
		 * e.click();
		 * 
		 * WebElement gaikuang = driver.findElement(By
		 * .xpath("//*[@id='nav']/li[2]/a"));
		 */
		WebElement e = driver.findElement(By
				.xpath("//*[@id='vl']/div/u1/li[3]"));
		System.out.println(e);
		Actions action = new Actions(driver);
		action.moveToElement(e).perform();
		// e.click();
		/*
		   List<WebElement> options = driver.findElements(By
		   .xpath("//*[@id='vl']/div/u1/li"));
		   
		   System.out.println(options); for (WebElement w : options) { if
		   (w.getText().contains("中日韩汉字表发布")) { System.out.println(w.getText());
		   w.click(); 
		   break; }
		  
		   }
		 */

	}

	@BeforeMethod
	public void beforeMethod() {

		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void afterMethod() {

		// driver.quit();

	}

	public static void MouseHoverByJavaScript(WebElement targetElement)

	{

		String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');"
				+

				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, " +
				"false, false, false, false, 0, null);"
				+

				"arguments[0].dispatchEvent(evObj);";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(mouseHoverjs, targetElement);

	}

}
