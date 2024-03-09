package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_22_Wait_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;
    By reformEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

    }
    @Test
    public void TC_01_Visible(){
        //CASE 1, IN UI AND HTLM
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("abc@gmail.com");
        sleepInSeconds(3);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reformEmailTextbox));

        Assert.assertTrue(driver.findElement(reformEmailTextbox).isDisplayed());

    }
    @Test
    public void TC_02_Invisible_in_Dom(){

        // CASE 2 not in UI, In HTML
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(3);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reformEmailTextbox));
        
        Assert.assertFalse(driver.findElement(reformEmailTextbox).isDisplayed());


    }
    @Test
    public void TC_02_Invisible_Not_In_Dom(){
        // not in UI, NOT in  HTLM
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(3);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reformEmailTextbox));

        //false because of not in dom
        Assert.assertFalse(driver.findElement(reformEmailTextbox).isDisplayed());


    }
    @Test
    public void TC_03_Presence(){
        //case 1: in UI and HTML
        // chi quan tam trong htlm
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("abc@gmail.com");
        sleepInSeconds(3);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reformEmailTextbox));

        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(3);
        // CASE 2 NOT IN ui but IN html
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reformEmailTextbox));



    }
    @Test
    public void TC_04_Staleness(){
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(2);

        WebElement reconformEmail = driver.findElement(reformEmailTextbox);

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInSeconds(3);

        // not in UI and in HTML
        explicitWait.until(ExpectedConditions.stalenessOf(reconformEmail));



    }
    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
    public  void sleepInSeconds(long timeSecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
