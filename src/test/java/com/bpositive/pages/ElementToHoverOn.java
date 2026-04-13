package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementToHoverOn {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/tool-tips");

        driver.manage().window().maximize();

        WebElement elementToHoverOn = driver.findElement(By.xpath("//div[@id='texToolTopContainer']/a[text()='Contrary']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(elementToHoverOn).perform();

        Thread.sleep(2000);

        WebElement tooltip = driver.findElement(By.xpath("//div[contains(@class,'tooltip-inner') and normalize-space(text())='You hovered over the Contrary']"));

        System.out.println(tooltip.getText());
    }

	}


