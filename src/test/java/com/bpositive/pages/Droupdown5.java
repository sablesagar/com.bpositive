package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Droupdown5 {

	
	    public static void main(String[] args) throws InterruptedException {
	    	 FirefoxDriver driver = new FirefoxDriver();
	        driver.get("https://demoqa.com/select-menu");
	        driver.manage().window().maximize();

	        WebElement oldDropdown = driver.findElement(By.id("cars"));

	        // Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oldDropdown);

	        Thread.sleep(2000);

	        Select select = new Select(oldDropdown);
	        select.selectByVisibleText("Audi");
	        select.selectByVisibleText("Saab");

	        Thread.sleep(3000);

	        select.deselectAll();

//	        driver.quit();
	    }
	}


