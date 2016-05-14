package cn.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScreen1 {

	public WebDriver driver;
	String url = "http://www.sogou.com/";

	@Test
	public void testSearch() {

		driver.get(url + "/");
		driver.findElement(By.id("query")).sendKeys("芈月传");
		driver.findElement(By.id("stb")).click();
		// 调用文件夹生成方法
		TimeString ts = new TimeString();
		String name = ts.getTimeString();

		String filename = "test" + name + ".png";// 生成不重复的文件夹名称
		//String filename = "test.png"; 
		
		File file = new File("E:\\" + filename);
		if (file.exists()) {//判断文件名称是否存在，如果存在重新生成一个新文件名称
			System.out.println("文件夹已存在");
			String name1=new TimeString().getTimeString() + ".png"; 
			System.out.println("新生成的文件名称为："+name1);
		 
			snapshot((TakesScreenshot) driver, name1);// 调用截图方法
		}else{
			snapshot((TakesScreenshot) driver, filename);// 调用截图方法
		}
		
		 
		
		

	}

	@BeforeMethod
	public void before() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	public static void snapshot(TakesScreenshot drivername, String filename) {
		// 该方法是屏幕截图,需要两个参数,一个是对象的名字,另一个是文件名

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);

		try {
			System.out.println("保存截图的路径:E:/" + filename);
			FileUtils.copyFile(scrFile, new File("E:\\" + filename));
		} catch (IOException e) {

			System.out.println("截图没有保存成功");
			e.printStackTrace();
		} finally {
			System.out.println("截图完成");
		}
	}

	// ​最后将此代码放到要截图的操作之后，就可以完成截图功能
	// snapshot((TakesScreenshot)driver,"open_test .png");

	// 判断文件是否存在方法，也可以不判断，但有可能生成的文件名重复
	public String getFileName(String path) {
		File file = new File(path);
		if (file.exists()) {
			System.out.println("文件夹已存在");
			return this.getFileName(file.getParent() + File.separator
					+ (new TimeString().getTimeString()) + ".png");
			//this.getFileName(file.getParent() 获得父目录
			//file.getParent()：  windows是\，unix是/
		}
		return path;
	}
}
