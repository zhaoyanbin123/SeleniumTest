package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class HomePage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap("");
	private WebDriver driver;
	public HomePage(){
		this.driver=driver;
		
	}
	//��ȡ��¼����ҳ�еġ�ͨѶ¼������
	public WebElement addressLink() throws Exception{
		 element=driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
		 return element;
		 //���Ҫ��HomePageҳ�������������ӻ�Ԫ�أ����Ը����Զ���
	}
 

}
