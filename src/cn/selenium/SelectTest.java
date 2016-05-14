package cn.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.support.ui.Select;
 
 
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SelectTest {
	
	public WebDriver driver;
	public String BaseUrl="http://127.0.0.1:1080/WebTours/";
  @Test
  public void f() {
	  driver.get(BaseUrl);
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	 
	  
	 /* 
	  try{
		  Thread.sleep(3000);
		  
	  }catch(Exception e1){
		  e1.printStackTrace();
	  }
	  */
	  frame();
	  driver.switchTo().frame("navbar");
	  driver.findElement(By.name("username")).sendKeys("jojo");
	  driver.findElement(By.name("password")).sendKeys("bean");
	  driver.findElement(By.name("login")).click();
	  
	  driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	 
	  frame(); 
	  driver.switchTo().frame("navbar");
	 
	  driver.findElement(By.xpath("html/body/center/center/a[1]/img")).click();
	 
	   frame();
	  
	  driver.switchTo().frame("info");
	 
	  //对下拉列表的操作
	  Select select=new Select(driver.findElement(By.name("depart")));
	  
	  List<String> except_option=Arrays.asList(new String[]{"Denver","Frankfurt",
			  "London","Los Angeles","Paris","Portland","San Francisco","Seattle",
			  "Sydney","Zurich"});
	  List<String> actual_option=new ArrayList <String>();
	  for(WebElement option: select.getOptions()){
		  actual_option.add(option.getText());
	
		 
	  }
	  Assert.assertEquals(except_option.toArray(), actual_option.toArray());
	  
	  select.selectByIndex(2); //第三个选项	
	  
	 
		  
		  
		 
		  
		  
	 

	 
  }
  
  public void frame(){
	  driver.switchTo().defaultContent();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("body");
	 
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}

