package cn.selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

  
public class TestAssert {
	  public WebDriver driver;
	  String BaseUrl="https://www.baidu.com/";
	  
  @Test
  public void f() {
	  driver.get(BaseUrl);
	  WebElement Select=driver.findElement(By.id("kw"));
	  //Assert.assertArrayEquals("", actuals)
	  Assert.assertTrue(Select.isDisplayed());
	  System.out.println(Select.isDisplayed());
	  Select.sendKeys("郭靖");
	  
	  
	  WebElement Select1=driver.findElement(By.id("su"));
	  Select1.click();
	  String URl=driver.getCurrentUrl();//获取当前网页的URL
	  System.out.println(URl);
	  Assert.assertNotSame(BaseUrl, URl);
	  System.out.println(BaseUrl);
	  //Assert.assertEquals("郭靖", driver.findElement(By.id("kw")).getText());
	 
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
