package com.qa.util;

import io.appium.java_client.TouchAction;

import java.io.File;
import java.io.IOException;

import net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;





import com.qa.base.Base;

public class UtilMethod extends Base {

	static TouchAction action;
	
	public static void scrollToText(String value){
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));");
		

	}
	
	
	public static void getScreenshot(String s) throws IOException{
		
		 File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\Screenshot\\"+s+".png"));
	}
	public static void dragAndDrop(WebElement src,  WebElement dest) throws IOException{
		
		 action = new TouchAction(driver);
		 action.longPress(element(src)).moveTo(element(dest)).release().perform();		
	}
	
	public static void swipe(WebElement src,  WebElement dest) throws IOException{
		
		 action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(src)).withDuration(ofSeconds(3))).moveTo(element(dest)).release().perform();
	}
	

}
