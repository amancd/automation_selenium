package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SeleniumGoogleSearch {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver (modify the path accordingly)
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Locate the search box and enter query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Learn Selenium in Java");
            searchBox.submit();

            // Wait for search results to load
            Thread.sleep(2000);

            System.out.println("Completed");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
        }
    }
}