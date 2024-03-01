package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.Point;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.WatchEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_14_Actions {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Hover_Tooltip(){
       // actions.click(driver.findElement(By.cssSelector(""))).perform();
       // actions.clickAndHold(driver.findElement(By.cssSelector(""))).release();
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTextbox).perform();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");


    }
    @Test
    public void TC_02_Hover_Menu_Login(){
        driver.get("https://www.fahasa.com/");
        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        sleepInSeconds(2);

        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();
        sleepInSeconds(2);
        /*actions.click(driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']"))).perform();
         sleepInSeconds(2);*/
        driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();


         //Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(),"THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
         Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());


    }
    @Test
    public void TC_03_ClickAndHold() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));

        Assert.assertEquals(allNumbers.size(),20);
        actions.clickAndHold(allNumbers.get(0))
                .moveToElement(allNumbers.get(14))
                .release()
                .perform();
        sleepInSeconds(2);
        //TONG SO DA DUOC CHON
        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("li.ui-state-default ui-selectee ui-selected"));
        Assert.assertEquals(allNumberSelected.size(),12);
    }

    @Test
    public void TC_04_doubleClick() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement doublClick = driver.findElement(By.xpath("//button[text()='Double click me']"));
        //Firefox can't run because element under the scroll
        if(driver.toString().contains("firefox")){
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",doublClick);
            sleepInSeconds(2);
        } else {
            actions.scrollToElement(doublClick).perform();
            sleepInSeconds(2);
        }

        actions.doubleClick(doublClick).perform();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }
    @Test
    public void TC_05_rightClick() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
        actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
        sleepInSeconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-hover.context-menu-visible")).isDisplayed());

        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
        sleepInSeconds(3);
        driver.switchTo().alert().accept();

        sleepInSeconds(3);


        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());

    }
    public void TC_06_DragDropHTML4(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(smallCircle,bigCircle).perform();
        //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
        sleepInSeconds(3);

        Assert.assertEquals(bigCircle.getText(),"You did great!");
        Assert.assertEquals(Color.fromString(bigCircle.getCssValue("background-color")).asHex().toLowerCase(),"#03a9f4");

    }

    @Test

    public void TC_07_DragDropHTML5_Css() throws IOException {
        //should not use
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        WebElement columnA = driver.findElement(By.cssSelector("div#column-a"));
        WebElement columnB = driver.findElement(By.cssSelector("div#column-b"));
        String projectPath = System.getProperty("user.dir");
        String drapAndDropFilePath = projectPath + "/DrapAndDrop/drag_and_drop_helper.js";

        String jsContentFile = getContentFile(drapAndDropFilePath);
        javascriptExecutor.executeScript(jsContentFile);
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");




    }
    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
    @Test
    public void TC_08_DragDropHTML5_Xpath() throws AWTException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        dragAndDropHTML5ByXpath("//div[@id='column-a']","//div[@id='column-b']");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");

    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }



        @AfterClass
    public void afterClass(){

        //driver.quit();
    }
    public  void sleepInSeconds(long timeSecond){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
