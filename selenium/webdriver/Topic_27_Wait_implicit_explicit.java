package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Date;

public class Topic_27_Wait_implicit_explicit {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Only_Implicit_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");

        //don't wait until finish 30s, return result if find element
        driver.findElement(By.cssSelector("input#email"));

    }
    @Test
    public void TC_02_Only_Implicit_Not_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");

        // can't find element > polling each 0,5s, finish timeout will throw exception: NoSuchElementException
        driver.findElement(By.cssSelector("input#automation"));

    }
    @Test
    public void TC_03_Only_Explicit_Found(){
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));


    }
    @Test
    public void TC_04_Only_Explicit_Not_Found(){
        driver.get("https://www.facebook.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // can't find element > polling each 0,5s, finish timeout will throw exception: TimeoutException

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));


    }
    public void TC_05_Mix_Explicit_Implicit(){
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        System.out.println("Start time:" + getDateTimeNow());

        try{
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        } catch (Exception e){
            System.out.println("End time:" + getDateTimeNow());
            e.printStackTrace();

        }



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
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }

}
