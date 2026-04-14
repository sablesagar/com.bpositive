package com.bpositive.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String montName = "june";

		String date = "15";

		String year = "2027";

		String[] expectedList = {montName,date,year};
		FirefoxDriver driver =new FirefoxDriver();

        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open date picker
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        // Select Month
        Select monthDropdown = new Select(driver.findElement(
                By.xpath("//select[@class='react-datepicker__month-select']")));
        monthDropdown.selectByVisibleText("May");

        // Select Year
        Select yearDropdown = new Select(driver.findElement(
                By.xpath("//select[@class='react-datepicker__year-select']")));
        yearDropdown.selectByVisibleText("2026");

        // Select Day (13)
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='13']"))
              .click();
    }
}