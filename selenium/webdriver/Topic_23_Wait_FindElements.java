package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_23_Wait_FindElements {
    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       /* fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        */
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_01_FindElement(){
        // case 1: Element is found with 1
        // do not wait unitl timeout (10s ) > return 1 element and go to next step
//        System.out.println("Start time:" + getDateTimeNow());
//        driver.findElement(By.cssSelector("input#email"));
//        System.out.println("End time:" + getDateTimeNow());
    //case 2: Element is found with more than 1
        // do not wait unitl timeout (10s ) > return 1 element and go to next step
//        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("abc@gmail.com");

        //case 3: element is not found
        // wait until finish timeout > find again every single second to find element
        // if find out an element > go to next step, but not return false testcase
        driver.findElement(By.cssSelector("input#not_found"));

    }
    @Test
    public void TC_02_FindElements(){
        List<WebElement> webElementList;
        /*System.out.println("Start time:" + getDateTimeNow());
        webElementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List have" + webElementList.size());
        System.out.println("End time:" + getDateTimeNow());
*/
        //case 2
       /* System.out.println("Start time:" + getDateTimeNow());
        webElementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List have: " + webElementList.size());
        System.out.println("End time:" + getDateTimeNow());*/

        //case 3
        System.out.println("Start time:" + getDateTimeNow());
        webElementList = driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("List have: " + webElementList.size());
        System.out.println("End time:" + getDateTimeNow());




    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }


}
