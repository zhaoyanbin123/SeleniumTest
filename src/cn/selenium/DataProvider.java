package cn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider {
	private static WebDriver driver;

	@org.testng.annotations.DataProvider(name = "serachWords")
	public static String[][] words() {

		return new String[][] { { "蝙蝠侠", "主演", "迈克尔" }, { "超人", "导演", "唐纳" },
				{ "生化危机", "编剧", "安德森" } };

	}

	@Test(dataProvider = "serachWords")
	public void test(String searchword1, String searchword2, String searchresult) {
		driver = new FirefoxDriver();
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(
				searchword1 + "" + searchword2);
		driver.findElement(By.id("stb")).click();
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 判断搜索结果的页面是否包含测试数据中期望的关键字
		Assert.assertTrue(driver.getPageSource().contains(searchresult));
		driver.quit();

		/*
		   测试结果： PASSED: test("蝙蝠侠", "主演", "迈克尔") PASSED: test("超人", "导演", "唐纳")
		   PASSED: test("生化危机", "编剧", "安德森")
		   测试脚本会自动打开三次浏览器，分别输入三组不同的测试数据作为搜索词进行查询， 并且三次搜索的结果均断言成功。
		  
		   @org.testng.annotations.DataProvider(name="serachWords") public
		   static String [][] words(){
		  
		   return new String [][]{{"蝙蝠侠","主演","迈克尔"},
		   {"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
		   
		  使用 @org.testng.annotations.DataProvider注解定义当前方法中的返回对象作为
		   测试脚本的测试数据集，并且将测试数据集命名为searchWords.
		   
		   @Test(dataProvider="serachWords") 
		   public void test(Stringsearchword1,String searchword2,String searchresult);
		   
		    上述代码表示测试方法中的三个参数分别使用searchWords测试数据集中 的每一个一维数组中的数据进行赋值，此
		    测试方法会被调用三次，分别使用测试数据集中的三组数据
		 */

	}
}
