package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Checkbox_Radio {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Default_Telerik(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        // click vao check box
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
        By airBags = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::input");

        checkToElement(airBags);
        checkToElement(dualZoneCheckbox);
        //verify checkbox da duoc chon
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(airBags).isSelected());

        uncheckToElement(airBags);
        uncheckToElement(dualZoneCheckbox);

        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(airBags).isSelected());

    }
    @Test
    public void TC_02_Default_Telerik_Radio(){
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
        By twoDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::input");
        checkToElement(twoPetrolRadio);

        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());

        checkToElement(twoDieselRadio);

    }
    @Test
    public void TC_03_Select_All_checkbox(){
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allcheckboxes = driver.findElements(By.cssSelector("div.form-input-wide input[type='checkbox']"));
        // chon tat ca cac checkbox trong man hinh
        for (WebElement checkbox:allcheckboxes){
            if (!checkbox.isSelected()){
                checkbox.click();

            }

        }
        //verify het tat ca
        for(WebElement checkbox:allcheckboxes){
            Assert.assertTrue(checkbox.isSelected());

        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allcheckboxes = driver.findElements(By.cssSelector("div.form-input-wide input[type='checkbox']"));

        for(WebElement checkbox:allcheckboxes){
            if(checkbox.getAttribute("value").equals("Heart Attact")&&!checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(2);
            }

        }
        //verify tat ca cac checkbox
        for(WebElement checkbox: allcheckboxes){
            if (checkbox.getAttribute("value").equals("Heart Attact")){
                Assert.assertTrue(checkbox.isSelected());
                sleepInSeconds(1);
            }
            else {
                Assert.assertFalse(checkbox.isSelected());
            }

        }


    }
    @Test
    public void TC_04_custom_checkbox(){
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
        //case 1 dung the input de click => the input bi che boi element khac >>failed
        //dung the div ben ngoai de click
        //dung theo div de verify
        // isSelected only applies to input elements

        //case 2: dung div click, verify by input

        driver.findElement(By.xpath("//div[text()='Dang ky cho nguoi than']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).click();

        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Dang ky cho nguoi than']/preceding-sibling::div/input']")).isSelected());

        //case 3
        //dung input click =>javascriptExecutor
        //use input to verify
        ((JavascriptExecutor)driver).executeScript("argument[0].click();",driver.findElement(By.xpath("//div[text()='Dang ky cho nguoi than']/preceding-sibling::div/input")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Dang ky cho nguoi than']/preceding-sibling::div/input']")).isSelected());
        /*JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("");*/


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
    public void checkToElement (By byXpath)
    {
        if(!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }
    public void uncheckToElement(By byXpath){
        if(driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

}
