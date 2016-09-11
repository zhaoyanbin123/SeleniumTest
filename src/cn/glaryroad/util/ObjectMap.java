package cn.glaryroad.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {

	Properties properties;

	public ObjectMap(String propFile) {
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("��ȡ�����ļ�����");
			e.printStackTrace();
		}

	}

	public By getLocator(String ElementNameInpropFile) throws Exception {
		// ���ݱ���ElementNameInpropFile�������������ļ��ж�ȡ��Ӧ�����ö���
		String locator = properties.getProperty(ElementNameInpropFile);
		// �����ö����еĶ�λ���ʹ浽locatorType����������λ���ʽ��ֵ����locatorValue����
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		/*
		 * Eclipse �е������ļ�Ĭ��ΪISO-8859-1����洢��ʹ��getBytes�������Խ��ַ�������ת����Ϊutf-8���룬
		 * �Դ�������������ļ���ȡ�������������
		 */
		locatorValue = new String(locatorValue.getBytes("ISO-8859-1"), "UTF-8");
		// ���locatorType����ֵ��locatorValue����ֵ����֤�Ƿ�ֵ��ȷ
		System.out.println("��ȡ�Ķ�λ����:" + locatorType + "\t��ȡ�Ķ�λ���"
				+ locatorValue);
		// ����locatorType����ֵ�����жϷ��غ��ֵĶ�λ��ʽ��By����
		if (locatorType.toLowerCase().equals("id")) {
			return By.id(locatorValue);

		} else if (locatorType.toLowerCase().equals("name")) {
			return By.name(locatorValue);

		} else if (locatorType.toLowerCase().equals("classname")
				|| locatorType.toLowerCase().equals("class")) {
			return By.className(locatorValue);
		} else if (locatorType.toLowerCase().equals("tagname")
				|| locatorType.toLowerCase().equals("tag")) {
			return By.tagName(locatorValue);

		} else if (locatorType.toLowerCase().equals("linktext")
				|| locatorType.toLowerCase().equals("link")) {
			return By.linkText(locatorValue);

		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return By.partialLinkText(locatorValue);

		} else if (locatorType.toLowerCase().equals("cssselector")
				|| locatorType.toLowerCase().equals("css")) {
			return By.cssSelector(locatorType);

		} else if (locatorType.toLowerCase().equals("xpath")) {
			return By.xpath(locatorValue);

		} else {
			throw new Exception("�����locatorTypeû���ڳ����ж��壺" + locatorType);
		}

	}

}
