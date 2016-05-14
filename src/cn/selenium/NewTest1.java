package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	public WebDriver driver;
	String url1="http://www.sougou.com";
	String url2="http://www.baidu.com";
  @Test
  public void Test() {
	  WebDriver driver=new FirefoxDriver();
	  //返回上一个访问的网页
	  driver.navigate().to(url1);//先访问搜狗首页
	  driver.navigate().to(url2);//再跳转到百度首页
	  driver.navigate().back();//返回到上一次访问的搜狗首页页面
	  //从上次访问网页页面前进到下一个网页
	  driver.navigate().forward(); //从搜狗首页跳转到百度首页
	  
	  //刷新当前网页
	  driver.navigate().refresh();//刷新当前网页
	  
	  //获取页面的title属性
	  String title=driver.getTitle();
	  System.out.println(title);
	  //断言页面的title是否是百度一下，你就知道
	  Assert.assertEquals("百度一下，你就知道", title);
	  
	  //获取页面的源码
	  String pageSource=driver.getPageSource();
	  System.out.println(pageSource);//打印源码
	  //断言页面的代码中是否还有“清空”关键字，以此判断页面内容是否正确
	   Assert.assertTrue(pageSource.contains("清空"));
	   //获取当前网页的URL
	   String  url=driver.getCurrentUrl();
	   System.out.println(url);
	   
	   //双击，某一元素
	   WebElement inputbox=driver.findElement(By.id("inputbox11"));
	   Actions builder=new Actions(driver);
	   //使用doubleClick 方法在输入框元素中进行鼠标双击动作
	   builder.doubleClick(inputbox).build().perform();
	   
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
