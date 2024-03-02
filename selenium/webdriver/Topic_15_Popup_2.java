package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Popup_2 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Random_In_Dom(){
        driver.get("https://vnk.edu.vn/");
        sleepInSeconds(50);

        By maketingPopup = By.cssSelector("div.tve-leads-conversion-object");
        if (driver.findElement(maketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
            sleepInSeconds(3);


        } else {
            System.out.println("popup is disable");
        }
        driver.findElement(By.cssSelector("button.btn-danger")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-content>h1")).getText(), "Lịch Khai Giảng Tháng 03");

    }
    @Test
    public void TC_02_Random_Not_In_Dom(){
        driver.get("https://www.javacodegeeks.com/");
        sleepInSeconds(10);
        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
         if (driver.findElements(newsletterPopup).size() > 0 && driver.findElements(newsletterPopup).get(0).isDisplayed()){ //render done, but dont now show or not
             driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a")).click();
             sleepInSeconds(3);

         } else {
             System.out.println("popup is disable");
         }
         driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
         //click search
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());

    }
    @Test
    public void TC_03_Random_Not_In_Dom() {
        driver.get("https://dehieu.vn/");
        By marketingPopup = By.cssSelector("div.title-content");

        if(driver.findElements(marketingPopup).size()>0 && driver.findElements(marketingPopup).get(0).isDisplayed()){
            System.out.println("popup is displayed");
            int heightBrowser = driver.manage().window().getSize().getHeight();
            if(heightBrowser<1920){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.cssSelector("button#close-popup")));

            }else {
                driver.findElement(By.cssSelector("button#close-popup")).click();
            }
            sleepInSeconds(3);

        }

    }
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
