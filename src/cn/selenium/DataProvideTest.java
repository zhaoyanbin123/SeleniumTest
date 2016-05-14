package cn.selenium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideTest {
 
	
//测试逻辑：
//1.打开搜狗首页
//2.从csv文件中读取每行中前面每个逗号分隔的中文词作为搜索框中输入的搜索关键词 
//3.单击搜索按钮 
//4.断言搜索结果页面是否包含csv文件中每行的第三个词汇，包含则认为测试执行成功，否则认为测试执行失败
	 

	public WebDriver driver;
	String url = "http://www.sogou.com/";

	// 使用注解DataProvider,将测试集命名为“testData”
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// 调用类中的静态方法 getTestdata，获取csv文件的测试数据
		return getTestData("d:\\testData.csv");

	}

	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2,
			String searchResult) {

		driver.get(url + "/");
		driver.findElement(By.id("query")).sendKeys(
				searchWord1 + "" + searchWord2);
		driver.findElement(By.id("stb")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(new ExpectedCondition<Boolean>() {
			@Override
			//@Override简单理解就是这个句话下边的方法是继承父类的方法，对其覆盖
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("s_footer")).getText()
						.contains("搜索帮助");
			}

		});

		// csv文件每行前两个词汇作为搜索词汇的情况下，断言搜索结果页面是否包含csv文件每行中的最后一个词汇的关键字
		Assert.assertTrue(driver.getPageSource().contains(searchResult));

		 

	}

	@BeforeMethod
	public void before() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	// 读取csv文件的静态方法，使用csv文件的绝对文件路径作为函数参数
	private static Object[][] getTestData(String fileName) throws IOException {
		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		// 设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
		BufferedReader file = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		// 忽略读取csv文件的标题行（第一行）
		file.readLine();
		
		//遍历读取文件中除第一行外的其他所有行内容， 并存储在名为records的对象为一个String数组
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);

		}
		file.close();// 关闭文件对象
		// 定义函数返回值，即Object[][]
		// 将存储参数数据的list转换为一个object的二维数组
		Object[][] results = new Object[records.size()][];
		// 设置二维数组每行的值，每行是一个Object对象
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);

		}
		return results;
	}
}
