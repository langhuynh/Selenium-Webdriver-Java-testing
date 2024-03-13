package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_26_explicit_Wait_03 {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath  = System.getProperty("user.dir");
    String file1 = "bug-example.jpg";
    String file2 = "englishtestcase.jpg";
    String file3 = "testcase_basic.jpg";

    String file1Path = projectPath + File.separator +"Upload_File" + File.separator +file1;
    String file2Path = projectPath + File.separator + "Upload_File" +File.separator +file2;
    String file3Path = projectPath + File.separator + "Upload_File" +File.separator +file3;

    @BeforeClass
    public void beforeClass() {

       driver = new FirefoxDriver();
       // driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(1000));

    }
    @Test
    public void TC_01_AjaxLoading(){

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.findElement(By.xpath("//a[text()='12']")).click();
        // wait until loading icon is disappeared
       //  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        // wait until the text is appeared
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),"Tuesday, March 12, 2024");
    }
    @Test

     public void TC_02_Upload_File(){

        driver.get("https://gofile.io/?t=uploadFiles");

       /* explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.spinner-border")));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button")));
        driver.findElement(By.cssSelector("a.ajaxLink>button")).click();
        */
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ajaxLink>button"))).click();

        // wait verify spiner icon is disappeared
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(file2Path + "\n" + file1Path +"\n"+ file3Path);

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        //verify button play, download
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file1 + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file2 + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file3 + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());


        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file1+ "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file2 + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='"+ file3+ "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']"))).isDisplayed());



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
