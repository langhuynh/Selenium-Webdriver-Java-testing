package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_21_Upload_File {
    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_single_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        //fix Path in this computer
    //    String filePath = "D:\\02-Selenium Webdriver\\Selenium-Webdriver-Java-testing\\Upload_File\\bug-example.jpg";

        By uploadBy = By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(file1Path);
        sleepInSeconds(2);

        driver.findElement(uploadBy).sendKeys(file2Path);
        sleepInSeconds(2);

        //verify file is loaded success
       // Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='englishtestcase.jpg']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+file1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+file2 +"']")).isDisplayed());


        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));
        for(int i = 0; i<startButtons.size();i++){
            startButtons.get(i).click();
            sleepInSeconds(3);
        }
        //file upload succeed
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+file1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+file2 +"']")).isDisplayed());

    }
    @Test
    public void TC_02_Multiple_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        //fix Path in this computer
        //    String filePath = "D:\\02-Selenium Webdriver\\Selenium-Webdriver-Java-testing\\Upload_File\\bug-example.jpg";

        By uploadBy = By.cssSelector("input[name='files[]']");
        driver.findElement(uploadBy).sendKeys(file1Path + "\n" +file2Path + "\n"+file3Path);
        sleepInSeconds(2);
        //verify file is loaded success
        // Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='englishtestcase.jpg']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+file1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+file2 +"']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));
        for(int i = 0; i<startButtons.size();i++){
            startButtons.get(i).click();
            sleepInSeconds(3);
        }
        //file upload succeed
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+file1 +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='"+file2 +"']")).isDisplayed());
    }
    @AfterClass
    public void afterClass(){
       // driver.quit();
    }
    public  void sleepInSeconds(long timeSecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
