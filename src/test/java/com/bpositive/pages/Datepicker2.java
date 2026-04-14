package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datepicker2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//FirefoxDriver driver=new FirefoxDriver();
		ChromeDriver driver =new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		
		Thread.sleep(3000);
	String aMonth =	driver.findElement(By.className("ui-datepicker-month")).getText();
	String ayear=	driver.findElement(By.className("ui-datepicker-year")).getText();
	
	while(!(aMonth.equals("May") && ayear.equals("2027"))) {
		
		driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		aMonth =	driver.findElement(By.className("ui-datepicker-month")).getText();
		ayear=	driver.findElement(By.className("ui-datepicker-year")).getText();
			
	}
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='13']")).click();
	}

}
