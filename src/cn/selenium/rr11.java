package cn.selenium;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class rr11 {
	
	public WebElement driver;
	public void SelectTest(){
		
		//操作下拉列表
		Select select=new Select(driver.findElement(By.id("XXX")));//定位下拉列表
		select.isMultiple();//表示此下拉列表是否允许多选,如果测试网页的下拉列表是一个单项下拉列表，
		//此函数返回结果为false
		Assert.assertFalse(select.isMultiple());//断言是否为false
		select.getFirstSelectedOption().getText();//方法表示获取当前被选中的下拉列表选项的文本
		Assert.assertEquals("VVV", select.getFirstSelectedOption().getText());
		//断言当前被选择的下拉列表是否为vvv
		select.selectByIndex(0);//通过下拉列表选项的下标选择 从0开始
		select.selectByValue("");//通过下拉列表选项的value值选择
		select.selectByVisibleText("");//通过下拉列表选项的文本选择
		
		
		//检查下拉列表的选项文字是否符合期望
		/*
		 先定位下拉列表，方法同上
		申明一个list对象  存储下拉列表中所有期望出现的文字选项，并且通过泛型<String>限定list对象
		中的存储对象时string
		Arrays.asList 表示将一个数组转换成一个list对象
		
		 
		 */
		
		Select droplist=new Select(driver.findElement(By.id("xxx")));
		List<String> except_option=Arrays.asList((new String[]{"xx","xxx","xxxx"}));
		//申明一个新的list对象，用于存储从页面上获取的所有选项文字
		List<String> actual_option=new ArrayList<String>();
		 for(WebElement option: droplist.getOptions()){
			 //droplist.getOptions();方法用于获取页面上下拉列表中的所有选项对象
	
			 actual_option.add(option.getText());
			 //actual_options.add(option.getText());方法用于将实际打开的
			 //的每个选项添加到actual_option列表中
			 
			 /*
			    toArray()，JAVA函数，当使用ArrayList时，有时想获得一个实际的数组，
			 这个数组包含了列表的内容。可以通过调用方法toArray()来实现。将actual_option直接转为Object[] 数组
			 
			 toString 方法返回一个“以文本方式表示”此对象的字符串
			 */
		 }
		 
		 Assert.assertEquals(except_option.toString(), actual_option.toArray());
		
	}
}
