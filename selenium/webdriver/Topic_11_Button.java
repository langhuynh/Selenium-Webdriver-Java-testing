package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class Topic_11_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Egov_Button_(){
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        //Verify button bi disable khi chua click vao
        Assert.assertFalse(registerButton.isEnabled());
        driver.findElement(By.cssSelector("input#chinhsach")).click();
        sleepInSeconds(2);
        //verify button enable khi da click vao
        Assert.assertTrue(registerButton.isEnabled());

        //lay ra ma mau nen cua button
        String registerBackgroundRGB= registerButton.getCssValue("background-color");

        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        //convert qua kieu Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        Assert.assertEquals(registerBackgroundHexa,"AeF5a00");


    }
    @Test
    public void TC_02_Fahasa_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");
        // chuyen qua tab dang nhap
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);
        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        Assert.assertFalse(loginButton.isEnabled());

        System.out.println(loginButton.getCssValue("background-color"));

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        // nhap Email/pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");
        // Verify login button is enable
        Assert.assertTrue(loginButton.isEnabled());
        // verify button Background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");
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
