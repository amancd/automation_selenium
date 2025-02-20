package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.name("username"));  // Locate username field
        WebElement password = driver.findElement(By.name("password"));    // Locate password field
        WebElement loginButton = driver.findElement(By.className("oxd-button--main")); // Locate by class

        username.sendKeys("Admin");
        password.sendKeys("admin123");

        loginButton.click();

        Thread.sleep(3000);

        System.out.println("Logged in! Current Page Title: " + driver.getTitle());

    }
}
