package com.qa.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.APIDemos;
import com.qa.pages.PreferencesDePage;
import com.qa.pages.ViewsPage;
import com.qa.util.UtilMethod;

public class APIDemoTest extends Base {

	APIDemos demo;
	PreferencesDePage preference;
	ViewsPage viewPage;
	
	@Test(priority = 1)
	public void scrollOnViewPage() {

		demo = new APIDemos(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		demo.views.click();
		UtilMethod.scrollToText("Tabs");

		PreferencesDePage preference = new PreferencesDePage(driver);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		

	}

	@Test(priority = 2)
	public void passTheInputValue() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		preference = new PreferencesDePage(driver);
		demo.preferences.click();
		preference.prefDependencies.click();
		preference.	checkBox.click();
		preference.WiFi_settings.click();
		preference.passInput("Arjun");
		preference.okButun.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
	

	}
	
	@Test(priority = 3)
	public void dragAndDrop() throws IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.navigate().back();
		 viewPage = new ViewsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		demo.views.click();
		 viewPage.dragDrop.click();
	
		UtilMethod.dragAndDrop(viewPage.drag_Position_fist,  viewPage.drag_Position_second);
		

	}
	@Test(priority = 4)
	public void swippingWatch() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		demo.views.click();
		
		

	}
	

	
	
	
	
	

}
