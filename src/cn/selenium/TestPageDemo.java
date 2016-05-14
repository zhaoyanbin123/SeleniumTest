package cn.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPageDemo {
	
	WebDriver driver;
	String url="https://www.baidu.com/";
	
	 //     ===判断页面元素是否存在===
	  //增加一个判断页面元素是否存在的函数，isElementPresent
	private boolean IsElementPresent(By by){
		try{
			//如果使用传入的参数by 找到页面元素，则函数返回true，表示成功的找到页面元素，
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e){
			//如果传入的参数by没有找到页面元素，则函数返回false，表示没有成功的找到页面元素
			return false;
			
		}
		
	}
  @Test
  public void Testpage() {
	  
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  //调用IsElementPresent方法查找页面id为kw的页面元素对象
	  if(IsElementPresent(By.id("kw"))){
		  //如果成功定位到页面元素，则把页面元素对象存储到search变量中
		  WebElement search=driver.findElement(By.id("kw"));
		  
		  if(search.isEnabled()){
			  //判断search变量对象是否处于可用状态，如果可用，在文本框中输入Selenium
			  search.sendKeys("Selenium");
			  
		  }
		  
	  }else{
		  //如果搜索输入框没有被找到，则会将此用例设置为fail，并打印失败原因
		  Assert.fail("输入框没有被找到");
	  
	  }
	  
	 
	  
  }
  @BeforeMethod
  public void Before(){
	  
	  driver=new FirefoxDriver();
  }
  @AfterMethod
  public void After(){
	  driver.quit();
  }
 
}
