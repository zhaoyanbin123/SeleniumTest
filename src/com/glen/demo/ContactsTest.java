package com.glen.demo;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class ContactsTest {
	private AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
		// 设置apk的路径
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "Apps");
		File app = new File(appDir, "app-bug.apk");
		// 设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		// 设置安卓系统版本
		capabilities.setCapability("platformVersion", "4.4");
		// 设置apk路径
		capabilities.setCapability("app", app.getAbsolutePath());
		// 设置app的主包名和主类名
		capabilities.setCapability("appPackage", "com.lthealth.iwo");
		capabilities.setCapability("appActivity",
				"com.lthealth.iwo.ui.activity.third.SplashActivity");
         //主包名和主类名可以在appium 设置中查看
		// 初始化
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	public void addContact() {
		for (int i = 0; i < 3; i++) {
			driver.swipe(787, 1245, 200, 0, 800);

		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}