package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;
    //tuong minh: trang thai cu the cho element, visible, invisible, presence, clickable

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Jquery(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInDropdown("span#speed-button","ul#speed-menu div","Medium");
        sleepInSeconds(2);

        selectItemInDropdown("span#files-button","ul#files-menu div","ui.jQuery.js");
        sleepInSeconds(2);

        selectItemInDropdown("span#number-button","ul#number-menu div","8");
        sleepInSeconds(2);


        selectItemInDropdown("span#salutation-button","ul#salutation-menu div","Mr.");
        sleepInSeconds(2);

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

    //nhung su lieu trueyn vao xem la parameter (tham so)

    public void selectItemInDropdown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click(); // span#number-button

        //xuat hien du trong html
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss))); //ul#number-menu div
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));

        for(WebElement item:allItems){
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)){
                item.click();
                break;
            }

        }

    }

}
