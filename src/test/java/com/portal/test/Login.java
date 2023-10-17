package com.portal.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	@Test
	public void portal_loin() throws InterruptedException {
		
		
		EdgeOptions options=new EdgeOptions();    
		options.addArguments("--remote-allow-origins=*");
		//System.setProperty("Webdriver.edge.driver","C:\\Users\\noorb\\eclipse-workspace\\NOORBASHA\\src\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@data-cy='closeModal']")));
		//driver.findElement(By.xpath("//span[@data-cy='closeModal']"))
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("HYD");
		Thread.sleep(1000);
		Actions ac =new Actions(driver);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("MAA");
		Thread.sleep(1000);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		//driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='departure']")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@aria-label='Thu Oct 26 2023']")).click();
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[@data-cy='returnDefaultText']")));
	Thread.sleep(1000);
	js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@aria-label='Tue Oct 31 2023']")));
	Thread.sleep(1000);
	js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p//a[contains(@class,'Search')]")));
	String txt=driver.findElement(By.xpath("//div[@class='flightsContainer makeFlex spaceBetween']//*[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']/span")).getText();
	Thread.sleep(3000);
	Assert.assertEquals(txt,"Flights from Hyderabad to Mumbai, and back");
	
	driver.close();
		
		
		
		
		
	}

}
