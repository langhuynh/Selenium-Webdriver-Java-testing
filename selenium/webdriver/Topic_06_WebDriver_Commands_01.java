package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebDriver_Commands_01 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_(){
        //mo 1 url bat ky
        driver.get("https://www.facebook.com/");
        //trả về 1 element khớp với đieều kiện
        WebDriver fullNameTextbox = (WebDriver) driver.findElement(By.id(""));

        // tra ve nhieu element khop voi dieu kien
        List<WebElement> texBoxee = driver.findElements(By.cssSelector(""));

        //Dung de verify 1 checkbox/radio/dropdown da duoc chon hay chua
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dropdown (default/custom)
        Select select = new Select(driver.findElement(By.id("")));

        //Dung de verify 1 element bat ky co hien thi hay khong
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        // dung verify 1 element co duoc thao tac len hay khong

        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        //html element
        driver.findElement(By.id("")).getAttribute("title");
        driver.findElement(By.id("")).getAttribute("type");

        //tab style trang elements GUI
        //font, size, collor/background
        driver.findElement(By.id("")).getCssValue("font-size");



    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
