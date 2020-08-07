package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;

/* I could not find the given condition Travel Money Overseas on launching the CommBank website,
	so, I performed the below steps-
	Login to CommBank page --> Click on Travel Products --> Tell us Before you go link -->
*/
public class HomePageTest extends Browser{
	public WebDriver driver;
	
	
	@BeforeMethod
	public void launchURL() {
		driver = browserInformation();
		driver.get(Config.getStringValue("url"));
		}
	
	
	@Test(priority=1)
	public void verifyPageContent() {
	// Click on Travel product on the CommBank Home Page
	driver.findElement(By.xpath("//div[contains(@class, 'card-header') and contains(., 'Travel products')]")).click();
	// Click on Tell us Before you go link on Travel Product Page
	driver.findElement(By.linkText("Tell us before you go")).click();
	// Check whether Before you go is present or not
	driver.findElement(By.id("before-you-go")).isDisplayed();
	// Limit webdriver scope in order to get the sub items present in the before you go item
	driver.findElement(By.id("before-you-go")).isDisplayed();
	List<WebElement> element= driver.findElements(By.xpath("//div[@class='item-section']"));
	System.out.println(element.size());
	// Click on the Login button 
	driver.findElement(By.xpath("//li[@class='logged-state-button']")).click();
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
