package com.bpositive.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Droupdown1 {

	public static void main(String[] args) throws InterruptedException {

		 FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/select-menu");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).click();

        Thread.sleep(3000);

        List<WebElement> allOptions = driver.findElements(By.xpath("//div[contains(@role,'option')]"));

        for(WebElement option : allOptions)
        {
            String expectedValue = option.getText();

            Thread.sleep(3000);

            if(expectedValue.contains("Group 2, option 1"))
            {
                option.click();

                System.out.println(expectedValue);
            }
        }

    }
}


