package com.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class ViewsPage  {

	public ViewsPage(AndroidDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
    public WebElement dragDrop;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
   public  WebElement drag_Position_fist;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_2")
    public WebElement drag_Position_second;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
    public WebElement dateWidgets;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']")
    public WebElement inline;
	
	@AndroidFindBy(xpath="//*[@content-desc='9']")
    public WebElement clickOn9;
	
	@AndroidFindBy(xpath="//*[@content-desc='45']")
    public WebElement clickOn15;
	
	@AndroidFindBy(xpath="//*[@content-desc='45']")
    public WebElement clickOn45;
	
	
	
	
	
}
