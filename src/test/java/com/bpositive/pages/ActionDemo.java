package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");   
		driver.manage().window().maximize();
		Actions a= new Actions(driver);
    WebElement move=driver.findElement(By.cssSelector("a[title='Login'] span"));
		
		
	
	
    a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Search for Products, Brands and More']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
    
    
	a.moveToElement(move).build().perform();
	}

}
