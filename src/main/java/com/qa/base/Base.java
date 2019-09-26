package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService server;

	public static void startAppiumServer() {
   
	boolean flag = checkIfServerIsRunnning(4723);
	if(flag){
		System.out.println("Port is alerdy runnning");
	}
	else{
		server = AppiumDriverLocalService.buildDefaultService();
		server.start();
		
	}

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
	
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\Reources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	
	@BeforeClass
	public void launchApp() throws IOException, InterruptedException {

		startAppiumServer();
		Thread.sleep(5000);
		FileInputStream src1 = new FileInputStream(
				".\\src\\main\\java\\com\\qa\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(src1);

		File src = new File(".\\src\\App\\" + prop.getProperty("appName"));
        String device = System.getProperty("device");
		System.out.println("project path  "+System.getProperty("user.dir"));
		DesiredCapabilities caps = new DesiredCapabilities();

		if (device.contains("Emulator")) {

			caps.setCapability("deviceName", device);
		} else if (device.contains("RealDevice")) {

			caps.setCapability("deviceName", prop.getProperty("device"));
		}

		caps.setCapability("app", src.getAbsolutePath());
		caps.setCapability("newCommandTimeout", "60");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
	}
	
	@AfterClass
	public void stopAppiumServer(){
		driver.quit();
		
		server.stop();
	}

}
