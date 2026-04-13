package com.bpositive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        String expectedUserName = "Sarah Lee";

        driver.get("https://vinothqaacademy.com/webtable/");

        driver.manage().window().maximize();

        List<WebElement> allFirstNames = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[2]"));

        for(WebElement oneByOnefirstName : allFirstNames)
        {
            if(oneByOnefirstName.getText().equals(expectedUserName))
            {
                driver.findElement(By.xpath("//td[text()='"+expectedUserName+"']/preceding-sibling::td/input[@type='checkbox']")).click();

            }
            //System.out.println("Hello World" + expectedUserName + "OKKK");

        }
    }
}
