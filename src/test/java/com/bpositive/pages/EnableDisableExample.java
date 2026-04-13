package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableDisableExample {

	

		  public static void main(String[] args) throws InterruptedException {

		        WebDriver driver = new ChromeDriver();
		        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		        driver.manage().window().maximize();
       System.out.println( driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
       driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
       Thread.sleep(3000);
       System.out.println( driver.findElement(By.xpath("//input[@type='text']")).isEnabled());        
    }
}
		
	


