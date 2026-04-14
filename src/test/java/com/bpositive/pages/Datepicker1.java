package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Datepicker1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://demoqa.com/date-picker");
		driver.manage().window().maximize();
		
		//select datepicker
		
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
        //month select
		
	Select Monthdroupdown= new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
	Monthdroupdown.selectByVisibleText("May");
		//year select
		
	Select Yeardroupdown=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		
	Yeardroupdown.selectByVisibleText("2027");
	
	
		driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='15']")).click();
	}

}
