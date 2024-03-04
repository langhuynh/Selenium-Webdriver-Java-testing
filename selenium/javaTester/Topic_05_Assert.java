package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;
    @Test
    public void verifyTestNG(){
        driver = new FirefoxDriver();
        driver.get("https://www.faceobook.com/");
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        //khi dieu kien mong muon dung assert Tru
        //Mong muon dieu kien tra ve sai thi dung assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));
    }

}
