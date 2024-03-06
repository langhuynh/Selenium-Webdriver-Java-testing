package webdriver;

import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_17_iframe {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

       // driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Form_Site(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSeconds(3);

        WebElement formIframe = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));
        Assert.assertTrue(formIframe.isDisplayed());

        //switch to frame/ifame before interact with iframe's element
        driver.switchTo().frame(formIframe);
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        sleepInSeconds(3);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");


    }
    @Test
    public void TC_02_KynaEnglish(){
        driver.get("https://skills.kynaenglish.vn/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(),"178K followers");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("cs_chat_iframe");
        driver.findElement(By.cssSelector("div.button_bar")).click();

        driver.findElement(By.cssSelector("input.input_name")).sendKeys("automation");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0198723483");
        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        driver.findElement(By.cssSelector("textarea.meshim_widget_widgets_TextArea")).sendKeys("toi lai");
        sleepInSeconds(3);

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("JAVA");
        driver.findElement(By.cssSelector("button.search-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.content>h4")).getText(),"Lập trình Java trong 4 tuần");

    }
@Test
    public void TC_03_Frame_HDFCbank() {
        //only for chrome
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        driver.switchTo().frame("login_page");
        driver.findElement(By.cssSelector("input[name= 'fldLoginUserId']")).sendKeys("luis_suarez");
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(3);
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
        sleepInSeconds(3);

    }
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
