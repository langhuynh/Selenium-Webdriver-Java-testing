package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_28_Wait_Fluent {
    WebDriver driver;
    FluentWait<WebDriver> fluentDriver;
    FluentWait<WebElement> fluentElement;
   // FluentWait<String> fluentString;*/
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
      //  driver = new ChromeDriver();
        driver.manage().window().maximize();
        fluentDriver = new FluentWait<WebDriver>(driver);
    }
    @Test
    public void TC_01_(){
        /*fluentDriver = new FluentWait<WebDriver>(driver);
        fluentElement =  new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));
        fluentString = new FluentWait<String>("hello world");

        // setting total time
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        //Polling time
        fluentDriver.pollingEvery(Duration.ofMillis(300));

        //ignore timeoutException
        fluentDriver.ignoring(NoSuchElementException.class);

        //Caution
        fluentDriver.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return null;
            }
        });*/
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        //wait hello world text display within 10s
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        fluentDriver.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
            }
        });

    }
    @Test
    public void TC_02_(){
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement = new FluentWait<WebElement>(countDownTime);

        fluentElement.withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                System.out.println("webElement = " + webElement.getText());
                return webElement.getText().endsWith("00");
            }
        });

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }


}
