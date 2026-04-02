package com.bpositive.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Table {

    public static void main(String[] args) {

      

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://portal2.npav.net/login");

        driver.findElement(By.cssSelector("label[for='dlrloginwithpassword']")).click();
        driver.findElement(By.id("DealerCode")).sendKeys("B-147");
        driver.findElement(By.id("pwd")).sendKeys("1234");
        driver.findElement(By.id("btnSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));

        WebElement keyMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//i[contains(@class,'ti-user')])[1]/parent::a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", keyMenu);

        // Sort by first column
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//th[1]"))).click();

        // ===== Validate sorting (2nd column) =====
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[2]"));

        List<String> originalList = elementsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedList = originalList.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(originalList, sortedList, "Table is NOT sorted properly");

        // ===== Search aging = 68 across pages =====
        List<String> engineerNames = new ArrayList<>();

        boolean hasNextPage = true;

        while (hasNextPage) {

            elementsList = driver.findElements(By.xpath("//tbody/tr/td[2]"));

            engineerNames = elementsList.stream()
                    .filter(e -> e.getText().contains("69"))
                    .map(Table::getEngineerName)
                    .collect(Collectors.toList());

            if (!engineerNames.isEmpty()) {
                break;
            }

            // Check next button state
            WebElement nextBtn = driver.findElement(By.id("datatable_next"));
            if (nextBtn.getAttribute("class").contains("disabled")) {
                hasNextPage = false;
            } else {
                nextBtn.findElement(By.tagName("a")).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
            }
        }

        // ===== Output =====
        if (engineerNames.isEmpty()) {
            System.out.println("No engineer found for aging = 68");
        } else {
            engineerNames.forEach(System.out::println);
        }

        driver.quit();
    }

    // Get Engineer Name from 3rd column
    private static String getEngineerName(WebElement cell) {
        return cell.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}

		    
		     
	
                             




