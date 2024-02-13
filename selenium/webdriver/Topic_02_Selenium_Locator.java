package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_ID(){
        // Selenium version: 1.x/2.x/3.x/4.x
        //8 locator
        // id/ Class/ Name = trung 3 attribute cua HTML
        // LinkText/ Partial LinkText: HTML Link (a)
        // Tagname: HTML Tagname
        // Css/ Xpath

        // Selenium verson 4.x - GUI (graphic User Interface)
        // Class - relative Locator
        // above/ bellow/near/leftOf/ rightOf

        // UI Testing
        // FUI: Functional UI

        // GU: Graphic UI
        // Font/ Size/ Color/ Position/ Resolution/ Responsive
        //System.out.println(driver.findElement(By.id("FirstName")));
    driver.findElement(By.id("FirstName")).sendKeys("King");
    }
    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("header-logo"));

    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));

    }
    @Test
    public void TC_04_Tagname(){
        driver.findElement(By.tagName("input"));

    }
    @Test
    public void TC_05_LinkText(){


    }
    @Test
    public void TC_06_Partial_Link(){

    }
    @Test
    public void TC_07_Css(){
        // css with ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        // Css with Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
        //css with Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        // css with Tagname
        driver.findElement(By.cssSelector("input"));
        // css with link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));
        // css with partial Link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
        //driver.findElement(By.cssSelector("a[href$='addresses']"));



    }
    @Test
    public void TC_08_XPath(){
        // css with ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        // Css with Class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        //css with Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));
        // css with Tagname
        driver.findElement(By.xpath("//input"));
        // css with link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));
        // css with partial Link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));

    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }

}
