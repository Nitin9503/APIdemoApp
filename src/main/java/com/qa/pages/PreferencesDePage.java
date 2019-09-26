package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class PreferencesDePage  {

	public PreferencesDePage(AndroidDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
   public  WebElement prefDependencies;
	
	@AndroidFindBy(id="android:id/checkbox")
    public WebElement checkBox;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='WiFi settings']")
   public  WebElement WiFi_settings;
	
	
	@AndroidFindBy(id="android:id/edit")
    WebElement WiFi_edit_field;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
   public WebElement okButun;
	
	public void passInput(String value){
		WiFi_edit_field.sendKeys(value);
		
	}
	
}
