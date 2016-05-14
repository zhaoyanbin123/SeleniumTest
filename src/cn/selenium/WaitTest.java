package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest {
	
	WebDriver driver;
  @Test
  public void testwait() {
	  
	  //常用的显示等待
	  //申明一个WebDriverWait 对象，设定触发条件的最长等待时间为10秒
	  
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  //调用ExpectConditions的titleContains方法判断页面Title属性是否包含水果两字
	  wait.until(ExpectedConditions.titleContains("水果"));
	  System.out.println("网页标题出现");
	  wait.until(ExpectedConditions.titleIs(""));//判断页面title是否是某内容
	  
	  //获取下拉列表中的“桃子”选项对象
	  WebElement select=driver.findElement(By.id(""));
	  //调用ExpectedConditions.elementToBeSelected();方法判断“桃子”是否是处于选中状态
	  
	  wait.until(ExpectedConditions.elementToBeSelected(select));
	  System.out.println("下拉列表的选项跳转慕容处于选中状态");
	  /*
	   * 调用ExpectedConditions.ElemntToBeClickable方法判断
	   * 页面的复选框对象是否可见，并且是否可被单击
	   * 
	   * */
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	  System.out.println("复选框处于显示状态，并且可被单击");
	  //调用ExpectedCpmditons.presenceOfElementLocated方法判断一个标签对象是否在页面中
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@value='ii']")));
	  System.out.println("页面的input标签已显示");
	  //调用ExpectedConditions的textToBePresentInElement方法判断p标签对象中是否包含“dddd”
      //这几个字
	  WebElement p=driver.findElement(By.xpath("//p"));
	  wait.until(ExpectedConditions.textToBePresentInElement(p,"ddd"));
	  System.out.println("页面p标签元素包含文本ddd");
	  
	  WebElement test=driver.findElement(By.id(""));
	  //判断对象的值是否为水果
	  wait.until(ExpectedConditions.textToBePresentInElementValue(test, "水果"));
	  System.out.println("值是水果");
	  
	  //等待某对象被选中或取消选中
	  
	 wait.until(ExpectedConditions.elementSelectionStateToBe(By.id(""),  true));
	 wait.until(ExpectedConditions.elementSelectionStateToBe(By.id(""),  false));
  }
 }
	  
	 /*
	    这里列出常用的waitFor命令  ：(ide 命令)

	    waitForElementPresent    locator    等待直到某个元素在页面中存在
	     
	    waitForElementNotPresent   locator   等待直到某个元素在页面中不存在
	     	
	    waitForTextPresent       text       等待直到某个文本在页面中存在
	    	  	
	     
	    waitForTextNotPresent    text      	等待直到某个文本在页面中不存在
	    
	    	
	    waitForText     locator   text   等待直到locator指定元素内的文本符合text
	     
	    	
	    waitForNotText    locator   text   	等待直到locator指定元素内的文本不符合text
	    
	    waitForVisible   locator            等待直到locator指定元素在页面中可见
	      
	    waitForNotVisible    locator        等待直到locator指定元素在页面中不可见
	     
	    waitForTitle      title      等待直到页面标题符合所指定的title
	     
	    	
	    waitForNotTitle    title       等待直到页面标题不符合所指定的title
	     
	    waitForLocation    url        等待直到页面的地址符合所指定的url
	     
	    	
	    waitForNotLocation  url       	等待直到页面的地址不符合所指定的url
	     
	    waitForValue    locator   value   等待直到locator指定的元素的value值符合指定的值
	   
	    waitForNotValue  locator  value   等待直到locator指定的元素的value值不符合指定的值
	    
	    waitForAttribute   locator@attr  value  等待直到locator指定的元素的attr属性值符合指定的值
	     
	    waitForNotAttribute locator@attr   value  等待直到locator指定的元素的attr属性值不符合指定的值
	    
	    waitForChecked   locator  等待直到locator指定的radio或checkbox成为选中状态
	     
	    waitForNotChecked  locator   等待直到locator指定的radio或checkbox成为非选中状态
	      
	    waitForEditable    locator   等待直到locator指定的input或textarea元素可编辑
	     
	    waitForNotEditable   locator  等待直到locator指定的input或textarea元素不可编辑
	      
	    waitForXpathCount   xpath   count   等待直到页面符合xpath的数量为count
	     
	    waitForNotXpathCount  xpath  count   等待直到页面符合xpath的数量不为count
	     
	    waitForEval   script   pattern    等待直到script的执行结果符合pattern
	      
	    waitForNotEval  script  pattern   等待直到script的执行结果不符合pattern 
	     
	   
	  */
 
