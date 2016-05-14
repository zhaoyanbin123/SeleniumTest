package com.example.tests;

 
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
 
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
 

public class Frametest{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://127.0.0.1:1080/WebTours/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
    driver.get(baseUrl);
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | body | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | navbar | ]]
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("jojo");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("bean");
    driver.findElement(By.name("login")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  @SuppressWarnings("unused")
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
