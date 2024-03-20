package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
@Listeners(listeners.extentReport.class)
public class Top_04_Dependencies {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_CreateNewUser(){

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewAndSearchUser(){
        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_03_UpdateExistingUser(){

    }
    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_04_DeleteUser(){
        Assert.assertTrue(false);

    }




    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
