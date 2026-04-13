package com.bpositive.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// Trigger alert
		driver.findElement(By.id("alertButton")).click();

		// Switch to alert
		Alert alert = driver.switchTo().alert();

		// Get alert text
		System.out.println("Alert says: " + alert.getText());
		// Accept the alert
		alert.accept();
		
		System.out.println("First Done");

		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(6000);
		Alert alert2 = driver.switchTo().alert();		
		System.out.println(alert2.getText());
		alert2.accept();
		
		System.out.println("Second Done");

		driver.findElement(By.id("confirmButton")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.dismiss();
		
		System.out.println("third Done");

		driver.findElement(By.id("promtButton")).click();
		Alert alert4 = driver.switchTo().alert();
		System.out.println(alert4.getText());
		alert4.sendKeys("premraj");
		alert4.accept();

	//	driver.quit();
	}
}

