  import org.openqa.selenium.*;
  import io.github.bonigarcia.wdm.WebDriverManager; 
  import org.openqa.selenium.chrome.ChromeDriver;
  import java.io.IOException;
  import java.net.HttpURLConnection;
  import java.net.URL;
  import java.util.List;
  
  public class BrokenLinkChecker {
      public static void main(String[] args) {
          WebDriverManager.chromedriver().setup();
  
          WebDriver driver = new ChromeDriver();
          driver.get("https://atomdyno.com");  
  
          List<WebElement> links = driver.findElements(By.tagName("a"));
  
          System.out.println("Total links found: " + links.size());
  
          for (WebElement link : links) {
              String url = link.getAttribute("href");
              if (url != null && !url.isEmpty()) {
                  checkBrokenLink(url);
              } else {
                  System.out.println("Empty or null href found.");
              }
          }
  
          driver.quit();
      }
  
      public static void checkBrokenLink(String url) {
          try {
              HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
              connection.setRequestMethod("HEAD");
              connection.connect();
              int responseCode = connection.getResponseCode();
  
              if (responseCode >= 400) {
                  System.out.println("Broken Link: " + url + " --> " + responseCode);
              } else {
                  System.out.println("Valid Link: " + url + " --> " + responseCode);
              }
  
          } catch (IOException e) {
              System.out.println("Error checking link: " + url);
          }
      }
  }
  
