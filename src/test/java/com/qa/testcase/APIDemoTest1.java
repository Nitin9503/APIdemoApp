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

public class APIDemoTest1 extends Base {

	APIDemos demo;
	PreferencesDePage preference;
	ViewsPage viewPage;

	@Test(priority = 1)
	public void swippingWatch() throws IOException, InterruptedException {
		demo = new APIDemos(driver);
		 viewPage = new ViewsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		demo.views.click();
		viewPage.dateWidgets.click();
		viewPage.inline.click();
		viewPage.clickOn9.click();
		UtilMethod.swipe(viewPage.clickOn15, viewPage.clickOn15);
		

	}

}
