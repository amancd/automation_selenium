package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class WindowHandleExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.selenium.dev', '_blank');");

        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // Switch to new window
                System.out.println("Switched to new window: " + driver.getTitle());
                break;
            }
        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Back to Main Window: " + driver.getTitle());

    }
}
