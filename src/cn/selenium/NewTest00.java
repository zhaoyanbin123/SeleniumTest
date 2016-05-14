package cn.selenium;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class NewTest00 {
  @Test
  public void f() {
	  System.out.println("方法一被调用");
	  Reporter.log("调用方法一");
  }
  @Test
  public void g(){
	  System.out.println("方法二被调用");
	  Reporter.log("调用方法二");
	  
  }
  @Test
  public void h(){
	  System.out.println("方法三被调用");
	  Reporter.log("调用方法三");
  }
}
