package com.bpositive.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datepicker5 {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		driver.findElement(By.id("first_date_picker")).click();

		int maxAttempts = 50;
		int count = 0;

		while (count < maxAttempts) {
			count++;

			String month = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-month")))
					.getText();

			String year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-year")))
					.getText();

			System.out.println(month + " " + year);

			if (month.equals("December") && year.equals("2026")) {
				break;
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Next']"))).click();
		}
	}
}

/*
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * FirefoxDriver driver = new FirefoxDriver();
 * 
 * driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
 * driver.manage().window().maximize();
 * 
 * driver.findElement(By.id("first_date_picker")).click();
 * 
 * 
 * String
 * CYear=driver.findElement(By.className("ui-datepicker-year")).getText();
 * 
 * String
 * CMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
 * 
 * while((CYear.equals("2024") && CMonth.equals("April"))) {
 * driver.findElement(By.className("ui-datepicker-year")).click();
 * driver.findElement(By.className("ui-datepicker-month")).click(); } } }
 */
