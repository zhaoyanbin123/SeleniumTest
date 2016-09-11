package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class AddressPage {
	private WebElement element=null;
	private ObjectMap objectMap=new ObjectMap("");//�����ļ�����·��
	private WebDriver driver;
	public AddressPage(){
		this.driver=driver;
		
	}
	//��ȡ�½���ϵ��ҳ���еĵ����ʼ������
	public WebElement createPersonEmail() throws Exception{
		 element=driver.findElement(objectMap.getLocator("126mail.homepage.Email"));
		 return element;
		  
	}
	//��ȡ�½���ϵ��ҳ�����ֻ��������
		public WebElement createPersonMoblie() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.Moblie"));
			 return element;
			  
		}
		//��ȡ�½���ϵ��ҳ���е����������
		public WebElement createPersonName() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.addressbook"));
			 return element;
			  
		}
		//��ȡ�½���ϵ��ҳ���е�ȷ����ť
		public WebElement saveButton() throws Exception{
			 element=driver.findElement(objectMap.getLocator("126mail.homepage.saveButton"));
			 return element;
			  
		}

}
