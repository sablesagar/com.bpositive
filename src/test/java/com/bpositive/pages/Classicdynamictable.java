package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Classicdynamictable {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/dynamic-table");

        // Correct XPath
        WebElement cpuCell = driver.findElement(By.xpath(
                "//table/tbody/tr[td[normalize-space()='Chrome']]/td[" +
                "count(//table/thead/tr/th[normalize-space()='CPU']/preceding-sibling::th)+1]"
        ));

        // Get text
        String chromeCpuValue = cpuCell.getText();

        // Print output
        System.out.println("Chrome CPU Value: " + chromeCpuValue);

        //driver.quit();
    }
}
