package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Slider {

	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/slider");

        driver.manage().window().maximize();

        // Locate the slider element

        WebElement slider = driver.findElement(By.id("slider"));

        // Desired target value

        int targetValue = 80;

        // Use JavaScriptExecutor to set the value directly
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));", slider, targetValue);

        // Verify the slider value

        String value = slider.getAttribute("value");

        System.out.println("Slider moved to: " + value);

    }
}