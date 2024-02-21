package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button span.ui-selectmenu-text")).getText(), "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button span.ui-selectmenu-text")).getText(), "8");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button span.ui-selectmenu-text")).getText(), "Mr.");


    }
    @Test
    public void TC_02_ReactJS(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("i.dropdown","div.item>span.text", "Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
        sleepInSeconds(2);

        selectItemInDropdown("i.dropdown","div.item>span.text", "Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu");
        sleepInSeconds(2);

        selectItemInDropdown("i.dropdown","div.item>span.text", "Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");
        sleepInSeconds(2);

    }
    @Test
    public void TC_03_VueJS(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
        sleepInSeconds(2);


    }
    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropdown("input.search","div.item span","Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Algeria");


        selectItemInEditableDropdown("input.search","div.item span","Australia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider")).getText(),"Australia");

    }
    @Test
    public void TC_05_NopCommerce(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
        selectItemInDropdown("select[name='DateOfBirthDay']","select[name='DateOfBirthDay']>option","18");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='18']")).isSelected());
        sleepInSeconds(2);


        selectItemInDropdown("select[name='DateOfBirthMonth']","select[name='DateOfBirthMonth']>option","September");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='9']")).isSelected());
        sleepInSeconds(2);


        selectItemInDropdown("select[name='DateOfBirthYear']","select[name='DateOfBirthYear']>option","1950");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='1950']")).isSelected());
        sleepInSeconds(2);



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
    public void selectItemInEditableDropdown(String parentCss, String childItemCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);

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
