package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_16_Shadow_Dom {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_shadow_Dom(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootContext = shadowHost.getShadowRoot();

        String someText= shadowRootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        WebElement test = shadowRootContext.findElement(By.cssSelector("input[type = 'checkbox']"));
        Assert.assertFalse(test.isSelected());


        List<WebElement> allInput = shadowRootContext.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        WebElement nestedShadowHostElement = shadowRootContext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRootContext = nestedShadowHostElement.getShadowRoot();

        String getText= nestedShadowRootContext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.println(getText);
    }
    @Test
    public void TC_02_shadow_shopee(){
        driver.get("https://shopee.vn/");
        sleepInSeconds(5);
        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();
        //verify popup is displayed
        if(shadowRootContext.findElement(By.cssSelector("div.home-popup__content")).isDisplayed()){
            //click to close popup
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSeconds(3);

            // enter data
        }
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("macbook pro 14");
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();
        sleepInSeconds(3);


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
