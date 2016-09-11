package cn.gloryroad.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.glaryroad.util.ObjectMap;

public class LoginPage {

	private WebElement element = null;
	// ָ��ҳ��Ԫ�ض�λ���ʽ�����ļ��ľ���·��
	private ObjectMap objectMap = new ObjectMap("");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// ���ص�¼ҳ���е��û������ҳ��Ԫ�ض���
	public WebElement userName() throws Exception {
		// ʹ��objectMap���е�getLocator������ȡ�����ļ��й����û������ʽ�Ķ�λ��ʽ�Ͷ�λ���ʽ
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.username"));
		return element;
	}

	// ���ص�¼ҳ���е����������ҳ��Ԫ�ض���
	public WebElement passWord() throws Exception {
		// ʹ��objectMap���е�getLocator������ȡ�����ļ��й����û������ʽ�Ķ�λ��ʽ�Ͷ�λ���ʽ
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.password"));
		return element;
	}

	// ���ص�¼ҳ���е����������ҳ��Ԫ�ض���
	public WebElement loginButton() throws Exception {
		// ʹ��objectMap���е�getLocator������ȡ�����ļ��й����û������ʽ�Ķ�λ��ʽ�Ͷ�λ���ʽ
		element = driver.findElement(objectMap
				.getLocator("126mail.loginPage.loginbutton"));
		return element;
	}
}
