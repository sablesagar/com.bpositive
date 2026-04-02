package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Automationexercise_demo {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Admin\\Downloads\\chromedriver-win64
		// (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();

		WebElement ele = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]"));
		ele.click();

		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.sendKeys("Gaurav");

		WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		email.sendKeys("gaurav123@gmail.com");

		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

		driver.findElement(By.id("id_gender1")).click();

		Boolean status = driver.findElement(By.id("id_gender1")).isSelected();
		System.out.println(status);

		// driver.close();
	}
}
