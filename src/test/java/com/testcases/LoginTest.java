package com.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.TestJiraListener;
import com.util.JiraPolicy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	
	@JiraPolicy(logTicketReady = true)
	@Test
	
	public void OrangeHRM()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String txt = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		
		Assert.assertEquals(txt, "Dashboardd");
		
		driver.close();
	}
}
