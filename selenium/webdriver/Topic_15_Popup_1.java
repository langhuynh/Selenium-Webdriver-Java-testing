package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Popup_1 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Fixed_In_Dom(){
        driver.get("https://ngoaingu24h.vn/");
        By loginPopup = By.cssSelector("div#modal-login-v1 div.modal-content");
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("button.login_")).click();
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#account-input")).sendKeys("automatio");
        driver.findElement(By.cssSelector("input#password-input")).sendKeys("123456");

        driver.findElement(By.cssSelector("button.btn-login-v1")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.error-login-panel")).getText(), "Tài khoản không tồn tại!");


    }
    @Test
    public void TC_02_Fixed_In_Dom_KyNa(){
        driver.get("https://skills.kynaenglish.vn/");
        By loginPopup = By.cssSelector("div#k-popup-account-login");
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(2);
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automatio");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");

        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

        driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
        sleepInSeconds(2);
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());


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

}
