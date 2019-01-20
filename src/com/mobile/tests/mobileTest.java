package com.mobile.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class mobileTest {
	AppiumDriver<MobileElement> driver;

@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setCapability("BROWSER_NAME", "Android");
//	capabilities.setCapability("VERSION", "4.4.2"); 
	capabilities.setCapability("deviceName","NSM3Y18206000488");
	capabilities.setCapability("udid","NSM3Y18206000488");
	capabilities.setCapability("platformName","Android");
   capabilities.setCapability("appPackage", "com.android.chrome");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
   
  // PageFactory.initElements(driver, this);
}




@Test
public void testCal() throws Exception {
//	home hm=new home(driver);
//	hm.searchText();
	searchText();
}


public void searchText() throws Exception {
	Thread.sleep(1000);
	driver.get("http://www.google.co.in");
	Thread.sleep(5000);
//	search.sendKeys("Harry");
   driver.findElement(By.xpath("//android.widget.EditText[@index=0]")).sendKeys("Hello");
   driver.findElement(By.xpath("//android.widget.Button[@text='Google Search']")).click();
//   ((AndroidDriver) driver).sendSMS("+919176790909", "Hey.. testing from scripts");
   Thread.sleep(5000);
//   JavascriptExecutor js = (JavascriptExecutor) driver;
//   HashMap<String, String> scrollObject = new HashMap<String, String>();
//   scrollObject.put("direction", "down");
//   js.executeScript("mobile: scroll", scrollObject);
  
   scrollDown();
   
//   driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
//   driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
//   WebElement plus=driver.findElement(By.name("+"));
//   plus.click();
//   WebElement four=driver.findElement(By.name("4"));
//   four.click();
//   WebElement equalTo=driver.findElement(By.name("="));
//   equalTo.click();
//   //locate the edit box of the calculator by using By.tagName()
//   WebElement results=driver.findElement(By.tagName("EditText"));
//	//Check the calculated value on the edit box
//assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

//   System.out.println("No. of links: "+ we.size());
   System.out.println("No. of links: "+ driver.findElements(By.xpath("//android.view.View[contains(@text,'https://')]")).size());
   Thread.sleep(5000);
}

public void scrollDown() throws Exception {

    //The viewing size of the device
    Dimension size = driver.manage().window().getSize();
    //Starting y location set to 80% of the height (near bottom)
    int starty = (int) (size.height * 0.80);
    //Ending y location set to 20% of the height (near top)
    int endy = (int) (size.height * 0.20);
    //endy=driver.findElement(By.xpath("//*[@text='Terms']")).getLocation().getY();
    //x position set to mid-screen horizontally
    int startx = size.width / 2;

    TouchAction touchAction = new TouchAction(driver);
    
    int i=8;
    while(i-->0) {
    touchAction
    .press(PointOption.point(startx, starty))
    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
    .moveTo(PointOption.point(startx, endy))
    .release().perform();
    }
//    touchAction.tap(PointOption.point(startx, endy)).perform();
//    touchAction.moveTo(PointOption.point(startx, endy)).perform();
    System.out.println("Tap Complete");
    
//    new TouchAction((PerformsTouchActions) driver)
//    .moveTo(new PointOption<>().point(startx, endy))
//            .release()
//            .perform();

}

@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}
}