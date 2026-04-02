package com.bpositive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://www.google.com/");
		driver.navigate().to("https://www.google.com");
		driver.navigate().to("https://facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

	}

}
