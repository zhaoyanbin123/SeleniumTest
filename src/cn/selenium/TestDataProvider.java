package cn.selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class TestDataProvider {

	// 测试逻辑：
	// 1.打开搜狗首页
	// 2.从csv文件中读取每行中前面每个逗号分隔的中文词作为搜索框中输入的搜索关键词
	// 3.单击搜索按钮
	// 4.断言搜索结果页面是否包含csv文件中每行的第三个词汇，包含则认为测试执行成功，否则认为测试执行失败

	public WebDriver driver;
	String url = "http://www.sogou.com/";

	// 使用注解DataProvider,将测试集命名为“testData”
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// 调用类中的静态方法 getTestdata，获取csv文件的测试数据
		return getTestData("E:\\", "testData.xlsx", "Sheet1");//注意Excel文件的sheet名称是否为Sheet1

	}

	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2,
			String searchResult) {

		driver.get(url + "/");
		driver.findElement(By.id("query")).sendKeys(
				searchWord1 + "" + searchWord2);
		driver.findElement(By.id("stb")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			// @Override简单理解就是这个句话下边的方法是继承父类的方法，对其覆盖
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("s_footer")).getText()
						.contains("搜索帮助");
			}

		});

		// 从Excel文件每行的前2个单元格内容作为搜索词汇的情况下，断言搜索结果页面是否包含Excel文件每行中第三个单元格内容的关键字
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

	// 从Excel文件读取测试数据的静态方法
	
	public static Object[][] getTestData(String filePath, String fileName,
			String sheetName) throws IOException {
		// 根据参数传入的数据文件路径和文件名称，组合出Excel数据文件的绝对路径
		// 声明一个file文件对象
		File file=new File(filePath+"\\"+fileName);
		//创建FileInputStream对象用于读取Excel文件
		FileInputStream inputStream=new FileInputStream(file);
		//声明Workbook对象
		Workbook Workbook = null;
		// 获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// 判断文件类型如果是.xlsx，则使用XSSFWorkbook对象进行实例化
		// 判断文件类型如果是.xls,则使用SSFWorkbook对象进行实例化
		if (fileExtensionName.equals(".xlsx")) {
			Workbook = new XSSFWorkbook(inputStream);

		} else if (fileExtensionName.equals(".xls")) {
			Workbook = new HSSFWorkbook(inputStream);

		}

		// 通过sheetName参数，生成Sheet对象
		Sheet Sheet = Workbook.getSheet(sheetName);
		// 获取Excel文件sheet1中数据的行数。getLastRowNum方法获取数据的最后一行行号
		// getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
		// 注意：Excel文件的行号和列号都是从0开始的
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		 
		// 创建名为records的list对象来存储从Excel数据文件读取的数据
		List<Object[]> records = new ArrayList<Object[]>();
		// 使用两个for循环遍历Excel数据文件的所有数据，（除了第一行，第一行是数据列名称）
		// 所以i从1开始，而不是从0开始
		for (int i = 1; i <rowCount+1 ; i++) {//rowCount+1
			// 使用getRow方法获取行对象
			Row row = Sheet.getRow(i);
			// 声明一个数组，用来存储Excel数据文件每行中的3个数据，数组的大小用
			// getLastCellNum办法来进行动态声明，实现测试数据个数和数组大小相一致
			String fileds[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// 调用getCell和getStringCellValue方法获取Excel文件中的单元格数据
				fileds[j] = row.getCell(j).getStringCellValue();

			}
			// 将fileds的数据对象存储到records的list中
			records.add(fileds);

		}
		// 定义函数返回值，及Object[][]
		// 将存储测试数据的list转换为一个Object的二维数组
		Object[][] results = new Object[records.size()][];
		// 设置二维数组每行的值，每行是一个Object对象
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);

		}
		return results;
	}

}
