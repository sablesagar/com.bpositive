package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ModalDilogs {

	
		public static void main(String[] args) throws InterruptedException {
			FirefoxDriver driver = new FirefoxDriver();
	        driver.get("https://demoqa.com/modal-dialogs");
	        driver.manage().window().maximize();
	        
	        driver.findElement(By.id("showSmallModal")).click();
	        Thread.sleep(1000);
	   String PopupHeading=driver.findElement(By.xpath("//div[text()='Small Modal']")).getText();
	        if(PopupHeading.contains("Small Modal")) {
	        	System.out.println("its open");
	        }
	        
	        driver.findElement(By.id("closeSmallModal")).click();
		}

	}

