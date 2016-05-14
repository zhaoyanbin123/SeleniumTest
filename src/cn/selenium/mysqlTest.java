package cn.selenium;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
 
public class mysqlTest {
	// 测试逻辑：
	// 1.打开搜狗首页
	// 2.从MySQL数据库中读取每行中前两列的中文词作为搜索框中输入的搜索关键词
	// 3.单击搜索按钮
	// 4.断言搜索结果页面是否包含数据库中每行的第三个词汇，包含则认为测试执行成功，否则认为测试执行失败

	public WebDriver driver;
	String url = "http://www.sogou.com/";
	// 使用注解DataProvider,将测试集命名为“testData”
	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		// 调用类中的静态方法 getTestdata，获取mysql数据库中的测试数据
		return getTestData("testdate");//数据库表名

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

		//在数据库中每行数据的前两列数据作为搜索词汇的情况下，断言搜索结果页面是否包含每个数据行中的第三列数据
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
	
	public static Object[][] getTestData(String tablename) throws IOException{
		//声明MySQL数据的驱动
		String driver1="com.mysql.jdbc.Driver";
		//声明本地数据库的IP地址和数据库名称
		String URL="jdbc:mysql://localhost:3306/test";//localhost
		//声明数据库的用户名，为简化数据库权限设定等操作 本例使用root用户进行操作
		//在正式对外服务的删除数据库中，建议使用非root的用户账户进行自动化测试的相关操作
		String user="root";
		//声明数据看root用户的登录密码，这和MySQL安装时设定的root用户密码要保持一致
		String password="1234";
		//声明存储测试数据的list对象
		List<Object[]> records=new ArrayList<Object[]>();
		try {
			//设定驱动
			Class.forName(driver1);
			//声明连接数据库的链接对象，使用数据库服务器地址你，用户名和密码作为参数
			Connection conn=DriverManager.getConnection(URL,user,password);
			//如果数据库链接可以用，打印数据库连接成功的信息
			if (!conn.isClosed()) {
				System.out.println("连接数据库成功");
				//创建statement对象
				
			}
			Statement statement=conn.createStatement();
			//使用函数参数拼接要执行的SQL语句，次语句用来获取数据表的所有数据行
			String Sql="select * from "+tablename;
			//声明一个ResultSet对象，存储执行sql语句后返回的数据结果表
			ResultSet rs=statement.executeQuery(Sql);
			//声明一个ResultSetMetaData对象
			ResultSetMetaData rsMetaData=rs.getMetaData();
			//调用ResultSetMetaData对象的getColumnCount方法获取数据行的行数
			int cols=rsMetaData.getColumnCount();
			//使用next方法变量数据结果集中所有数据行
			while (rs.next()) {
				//声明一个字符型数据，数组大小使用数据行的列个数进行声明
				String fields[]=new  String [cols];
				int col=0;
				//遍历所有数据行中的所有列数据，并存储到字符数组中
				for (int colIdx = 0; colIdx < cols; colIdx++) {
					fields[col]=rs.getString(colIdx+1);
					col++;
			 
				}
				//将每一行的数据存储到字符数据后，存储到records中
				records.add(fields);
				//输出数据行中的前三列内容，用于验证数据库内容是否正确取出
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"	"+rs.getString(3));
			 
			}
			//关闭数据结果集对象
			rs.close();
			//关闭数据库连接
			conn.close();
			
		} catch(ClassNotFoundException e){
			System.out.println("未能找到MySQL的数据驱动类！");
			e.printStackTrace();
		}catch (SQLException e1) {
			 
			e1.printStackTrace();
		}catch (Exception e2) {
			 e2.printStackTrace();
			 
			
		}
		//定义函数返回值 ，即Object[][]
		//将存储测试数据的list转换为一个Object的二维数组
		Object[][] results=new Object[records.size()][];
		//设置二维数组每行的值，每行是一个Object对象
		for(int i=0;i<records.size();i++){
			results[i]=records.get(i);
			
		}
		return results;
			
	}
}
