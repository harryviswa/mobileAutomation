package com.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSFindAll;

public class home {
	
	AppiumDriver<MobileElement> driver;
	
	@AndroidFindAll(value = { @AndroidBy(xpath="//android.view.View[contains(@text,'https://')]") })
	@iOSFindAll(value = { @iOSBy(xpath="//android.view.View[contains(@text,'https://')]")})
	public List<MobileElement> we;
	
	
	@AndroidBy(xpath="//android.widget.EditText[@index=0]")
	MobileElement search;

	public home(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements((this.driver), this);
	}
	
	public void searchText() throws Exception {
		Thread.sleep(1000);
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		search.sendKeys("Harry");
	//   driver.findElement(By.xpath("//android.widget.EditText[@index=0]")).sendKeys("Hello");
	   driver.findElement(By.xpath("//android.widget.Button[@text='Google Search']")).click();
	//   ((AndroidDriver) driver).sendSMS("+919176790909", "Hey.. testing from scripts");
	   Thread.sleep(5000);
	//   JavascriptExecutor js = (JavascriptExecutor) driver;
	//   HashMap<String, String> scrollObject = new HashMap<String, String>();
	//   scrollObject.put("direction", "down");
	//   js.executeScript("mobile: scroll", scrollObject);
	  
	  
	   //scrollDown();
	   
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
//		//Check the calculated value on the edit box
	//assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

	   System.out.println("No. of links: "+ we.size());
	//   System.out.println("No. of links: "+ driver.findElements(By.xpath("//android.view.View[contains(@text,'https://')]")).size());
	   Thread.sleep(5000);
	}

}
