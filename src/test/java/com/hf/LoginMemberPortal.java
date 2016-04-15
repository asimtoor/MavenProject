package com.hf;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMemberPortal{
    
	
	@Test
	public void testLaucnhMPHomePage(){
		System.setProperty("webdriver.chrome.driver", "F:\\WIN7-BACKUP\\Drive-F\\Java - Selenium\\maven_projects\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://secure.healthx.com/hf-member-redesign");
		String mpSiteTitle = driver.getTitle();
		System.out.println(mpSiteTitle + " Site is successfully launched!");
		driver.quit();
	}
	
	@Test
	public void testMPLogin(){
		System.setProperty("webdriver.chrome.driver", "F:\\WIN7-BACKUP\\Drive-F\\Java - Selenium\\maven_projects\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://secure.healthx.com/hf-member-redesign");
		driver.get("https://staging.myhfny.org");
		
		
		if (driver.findElements(By.xpath("//*[@id='username']")).size() > 0){
			try{
				driver.findElement(By.cssSelector("[id='username']")).sendKeys("stab22");
			}catch(Exception e){
				System.out.println("Username Editbox is either disabled or not displayed: [" + e.getMessage()+ "]");				
			}
		}
		if (driver.findElements(By.xpath("//*[@id='password']")).size() > 0){
			try{
				driver.findElement(By.cssSelector("[id='password']")).sendKeys("test@2015");
			}catch(Exception e){
				System.out.println("Password Editbox is either disabled or not displayed: [" + e.getMessage()+ "]");				
			}
		}
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		System.out.println("Successfully clicked on Login button after passing user credentials!");
		
		if (driver.findElements(By.xpath("//*[@id='loginButton']")).size() > 0){
			System.out.println("Login Test is Failed! Check user credentials ...");		
		}else{
			System.out.println("User is successfully Logged in!");
		}
		
		driver.quit();
	}
}
