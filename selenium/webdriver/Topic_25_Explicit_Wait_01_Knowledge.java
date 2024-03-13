package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_Explicit_Wait_01_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        // create 1  explicit wait has total 10s = polling 0.5s default
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //create 1 explicit wait has total 10s-polling 0.3s set up
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10), Duration.ofMillis(300));


         driver.manage().window().maximize();

    }
    @Test
    public void TC_01_(){
        //wait 1 alert presence in html/dom before implement
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        // wait an element is no longer in Dom
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // wait an element has in Dom, don't care on UI
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // wait a list element has in Dom, don't care on UI
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //wait until 1-n elements is displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        //wait element can be clicked: link/button/checkbox/radio

        //wait until page has title likes expected
        explicitWait.until(ExpectedConditions.titleIs("Create New Customer Account"));
        driver.getTitle();



    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    public  void sleepInSeconds(long timeSecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
