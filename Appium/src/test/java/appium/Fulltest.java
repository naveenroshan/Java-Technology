package appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Fulltest {
	
	public  AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void LaunchingApp() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		//to get apk from the local drive.
		File appDir = new File("/E:/Downloads/sportscenter-debug-6.3.0-Local-7049-debug.apk");
		//list of capabilities
        caps.setCapability("deviceName", "Samsung");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("appPackage", "com.espn.score_center.debug");
        caps.setCapability("appActivity","com.espn.sportscenter.ui.LaunchActivity");
        // to remove the app after test done
        caps.setCapability("Reset","true");
        // to get the app from local drive
        caps.setCapability("app", appDir.getAbsolutePath());
        //to get the mobile elements by using driver.
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        System.out.println("Test started");
        
	}
	
	@Test
	public void loginskip() throws InterruptedException{
        
		Thread.sleep(1000);       
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/btn_sign_up_later")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/nextText")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/nextText")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/button1")).click();    
    }
	
	@Test
	public void login() throws InterruptedException{
        
		Thread.sleep(1000);       
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/btn_login")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/nextText")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.espn.score_center.debug:id/nextText")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/button1")).click();    
    }

	@AfterTest	
	public void closeApp() throws Exception {
		try
		{
		File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File("C:/Users/Naveen.s2/Desktop/" + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
		}
		finally
		{
		driver.removeApp("com.espn.score_center.debug");
		System.out.print("Test ended");
	}
}
}

	