package cn.selenium;
 
import org.testng.annotations.Test;

public class Testcase {
	
  @Test(dependsOnMethods={"test1"})
  public void test0() {
	  System.out.println("这个方法被调用："+111);
	  
  }
  @Test
  public void test1(){
	  System.out.println("这个方法被调用:"+6666);
	  
  }
  
  @Test(dependsOnMethods=("test1"))
  public void test2(){
	  System.out.println("这个方法被调用:"+222);
  }
}
