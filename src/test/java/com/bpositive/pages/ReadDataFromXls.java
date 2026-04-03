package com.bpositive.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromXls {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// read xls data
		String filepath = "C:\\Users\\Admin\\eclipse-workspace\\com.bpositive\\src\\test\\resources\\data1.xlsx";

		FileInputStream fis = new FileInputStream(filepath);
		Workbook workbook = new HSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("data1");
		
		
		
		// HSSFWorkbook
		// XSSFWorkbook
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			String userName = row.getCell(0).getStringCellValue();
			String passWord = row.getCell(1).getStringCellValue();

			WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
			username.sendKeys(userName);
			WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			password.sendKeys(passWord);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

		}

		workbook.close();
		fis.close();
		driver.quit();

	}

}
