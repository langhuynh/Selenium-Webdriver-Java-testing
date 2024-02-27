package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.concurrent.TimeUnit;

public class Topic_14_Actions {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Hover_Tooltip(){
       // actions.click(driver.findElement(By.cssSelector(""))).perform();
       // actions.clickAndHold(driver.findElement(By.cssSelector(""))).release();
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTextbox).perform();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");


    }
    @Test
    public void TC_02_Hover_Menu_Login(){
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepInSeconds(2);

        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();
        sleepInSeconds(2);
        /*actions.click(driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']"))).perform();
         sleepInSeconds(2);*/
        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();


         //Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
         Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());


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
