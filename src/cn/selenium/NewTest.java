package cn.selenium;

 
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.support.ui.Select;
 
 
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	public WebDriver driver;
	public String BaseUrl="http://127.0.0.1:1080/WebTours/";
  @Test
  public void f() {
	  driver.get(BaseUrl);
	  driver.manage().window().maximize();
	  
	  
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  
	  
	  
	 /* 
	  try{
		  Thread.sleep(3000);
		  
	  }catch(Exception e1){
		  e1.printStackTrace();
	  }
	  */
	  
	  
	  //像这种frme嵌套frame的 要定位里面frame中的元素  需要先进入外面的frame  然后在进入里面的
	  //frame 才能进行定位操作  不然是定位不到元素的
	  
	  /*
	  driver.switchTo().frame("body");  //将此步骤 写在frame()方法中 方便后续使用
	  driver.switchTo().frame("navbar");
	  */
	  frame();
	  driver.switchTo().frame("navbar");
	   
	  driver.findElement(By.name("username")).sendKeys("jojo");
	  driver.findElement(By.name("password")).sendKeys("bean");
	  driver.findElement(By.name("login")).click();
	  
	  driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
	  /*
	  driver.switchTo().defaultContent();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("body");
	  driver.switchTo().frame("navbar");*/
	  
	  frame(); 
	  driver.switchTo().frame("navbar");
	 
	  driver.findElement(By.xpath("html/body/center/center/a[1]/img")).click();
	  //driver.findElement(By.xpath("//a[@href='welcome.pl?page=search']")).click();

	 // driver.switchTo().defaultContent().switchTo().frame("body");
	  
	   frame();
	  
	  driver.switchTo().frame("info");
	//  driver.findElement(By.name("depart")).click();
	  //获取下拉列表中的内容
	  Select select=new Select(driver.findElement(By.name("depart")));
	  select.selectByIndex(2); //第三个选项	
	  
	/*  
	  List<WebElement> element = driver.findElements(By.tagName("frame"));
	  System.out.println(element);
	  for(WebElement e:element){
		  driver.switchTo().frame(e);
		  System.out.println(e.getAttribute("name"));
		  if(e.getAttribute("name") == "navbar"){
			  driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input[@name=username]")).sendKeys("jojo");
			  driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]/input[@name=password]")).sendKeys("bean");
			  driver.findElement(By.xpath("//table/tbody/tr[9]/td[2]/input[@name=login]")).click();

		  }else{
			  driver.switchTo().defaultContent();
	  
		  }
		  }
	  
		  */
		  
		  
		  /*
	  
	  driver.switchTo().frame("body");
		driver.findElement(By.tagName("table"));
		 List<WebElement> rows=driver.findElements(By.tagName("tr"));
		 for(WebElement row: rows){
			 List<WebElement> cols=	 row.findElements(By.tagName("td"));
			 for(WebElement col:cols){
				 System.out.println(col.getText());
			 }
			 System.out.println("");
		 }
		  
	  */
		  
		  
	  //driver.switchTo().frame("body").findElement(By.name("username")).sendKeys("jojo");
	  //driver.switchTo().defaultContent();
	  
	  //driver.switchTo().frame(driver.findElement(By.name("navbar")));
	  
	  /*
	  (new WebDriverWait(driver,30)).until(new ExpectedCondition<Boolean>(){
		  public Boolean apply(WebDriver d){
			  WebElement el = driver.findElement(By.xpath("html>body>form>table>tbody>tr>td>small"));
			  return el.getText().equals("password");
		  }
	  });
	  */
//	  String currentWindow = driver.getWindowHandle();
//	  System.out.println(currentWindow);
	  
	  
	  //WebElement body = driver.findElement(By.name("navbar"));
	  //driver.switchTo().frame("body");
	 // driver.switchTo().defaultContent();
	 // driver.switchTo().frame("navbar");
	 
	  //driver.switchTo().frame("navbar");
	  //WebElement table=driver.findElement(By.xpath("//table[@border='0']"));
	 //driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input[@name='username']")).sendKeys("jojo");
	  //tr[4]/x:td[2]/
	  //driver.findElement(By.xpath("//*[id='username']/tbody/tr[4]/td[2]")).sendKeys("jojo");
	  //driver.findElement(By.name("username")).sendKeys("jojo");
	  //driver.findElement(By.name("password")).sendKeys("bean");
	  
	//  driver.findElement(By.xpath("//input[@name='login']"));
	  
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
//F5 ：step into 跳入  F6 跳过 step over  F7 跳出  step return
  //drop to frame 跳到当前方法的第一行
  //resune:跳到下一个断点 如果没有下一个，则运行完整个程序
  //watch:观察变量或表达式的值
}
