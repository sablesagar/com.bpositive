package com.bpositive.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NpavLinkedValidate {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://npav.net/");
		driver.manage().window().maximize();

		WebElement footerdriver = driver.findElement(By.cssSelector("footer.footer-area"));

		// Correct footer products column XPath
		WebElement columdriver = footerdriver
				.findElement(By.xpath("//footer//h3[contains(text(),'Products')]/following-sibling::ul"));

		// Store all links in a List (IMPORTANT)
		List<WebElement> links = columdriver.findElements(By.tagName("a"));

		System.out.println("Total links: " + links.size());

		for (int i = 0; i < links.size(); i++) {

			String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			links.get(i).sendKeys(openInNewTab);

			Thread.sleep(2000);
		}

		// Print titles of all opened tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
