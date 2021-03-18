package com.bankguru.login;

import org.testng.annotations.Test;

import commons.AbstracTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_And_Login extends AbstracTest {
	WebDriver driver;
	String loginPsgeUrl, userID, password;

	@Parameters({ "browser", "inviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviName) {
		driver = getBrowserDriver1(browserName, enviName);
		System.out.println("Class 0fgfff 1");
	}

	@Test
	public void TC_01_Register() {
		System.out.println("Register01 - Step 01: Get Login Page Url");
		loginPsgeUrl = driver.getCurrentUrl();

		System.out.println("Register - Step 02:Click to 'here' link");
		driver.findElement(By.xpath("//a[text()='here']")).click();

		System.out.println("Register - Step 03:Input To Email textbox");
		driver.findElement(By.name("emailid")).sendKeys("minhanh123@gmail.com");

		System.out.println("Register - Step 04:Click to submit button");
		driver.findElement(By.name("btnLogin")).click();

		System.out.println("Register - Step 05: Get UserID/Password information");
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void TC_02_Login() {
		System.out.println("Login - Step 01:Open Login Page");
		driver.get(loginPsgeUrl);
		System.out.println("Login - Step 02:Input to username/password");
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);

		System.out.println("Login - Step 03:Click to login button");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("Login - Step 04:Navigate to home page");
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),"Welcome To Manager's Page of Guru99 Bank");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
