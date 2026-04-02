package com.bpositive.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();

		driver.get("https://npav.net/");
// give totalcount of link
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerdriver = driver.findElement(By.cssSelector("footer.footer-area"));

		// Count links inside footer
		List<WebElement> footerLinks = footerdriver.findElements(By.tagName("a"));
		System.out.println("Links in footer: " + footerLinks.size());

		WebElement columdriver = footerdriver
				.findElement(By.xpath("//footer//h3[contains(text(),'Products')]/following-sibling::ul"));

		// body[1]/footer[1]/div[1]/div[1]/div[2]/div[1]/ul[1]

		List<WebElement> links = columdriver.findElements(By.tagName("a"));

		System.out.println("Total links: " + links.size());

		for (int i = 0; i < links.size(); i++) {

			String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			links.get(i).sendKeys(openInNewTab);

			Thread.sleep(2000);
		}
//print footer link name 
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext())

		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
