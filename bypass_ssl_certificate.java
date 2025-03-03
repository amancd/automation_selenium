  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  
  public class SSLCertificateBypass {
      public static void main(String[] args) {
          WebDriverManager.chromedriver().setup();
  
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--ignore-certificate-errors");  // Ignore SSL errors
          options.addArguments("--allow-insecure-localhost");   // Allow localhost issues
          options.addArguments("--disable-popup-blocking");     // Disable pop-ups
          options.setAcceptInsecureCerts(true);                 // Accept insecure certificates
  
          // Initialize WebDriver with options
          WebDriver driver = new ChromeDriver(options);
  
          // Open the website (atomdyno.com)
          driver.get("https://atomdyno.com");
  
          // Print page title to verify successful navigation
          System.out.println("Page Title: " + driver.getTitle());
  
          // Close browser
          driver.quit();
      }
  }


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class HandleCookies {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.atomdyno.com");

        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        // Print all cookies
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        // Close browser
        driver.quit();
    }
}
 
