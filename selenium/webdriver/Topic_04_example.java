package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_example {
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
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_(){
        driver.get("http://live.techpanda.org/index.php");
        // Click vao My Account at Header
        //co7o che selenium findElement luon thao tac vao element dau tien duoc tim thay
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        //div[@class='footer']//a[@title='My Account']
        //li[@class='success-msg']//span

        String successMessageText = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
        Assert.assertEquals(successMessageText, "Samsung Galaxy was added to your shopping cart");

    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
