package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverExample {

	public static void main(String[] args) throws InterruptedException {

        int sliderValue = 70;

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/slider");

        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.id("slider"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 50, 0).perform();

        String currentSliderValue = slider.getAttribute("aria-valuenow");

        System.out.println(currentSliderValue);
    }
}