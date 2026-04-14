package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datepicker3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxDriver driver=new FirefoxDriver();
		 driver.get("https://jqueryui.com/datepicker/#default");
		 
		 driver.manage().window().maximize();
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("datepicker")).click();
		 
		 Thread.sleep(3000);
		 //month
	String aMonth=	 driver.findElement(By.className("ui-datepicker-month")).getText();
		 //year
	String aYear=	 driver.findElement(By.className("ui-datepicker-year")).getText();
		 
		 
		// 13/may//2027
	
	while(!(aMonth.equals("May") && aYear.equals("2027")))
	{
		driver.findElement(By.className("ui-datepicker-month")).getText();
		driver.findElement(By.className("ui-datepicker-year")).getText();
	}
	
	driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='13']")).click();
	}
		//13/may/2027
		
	}


