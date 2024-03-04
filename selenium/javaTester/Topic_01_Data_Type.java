package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Topic_01_Data_Type {
    // kieu du lieu
    // I- kieu du lieu nguyen thuy (Primitive Type)
    // 8 loai
    // so nguyên: byte - short - int - long
    // không co phần thập phân: nhaân viên trong 1 cty, học sinh, trường
    //range

    // so thực: float - double
    //có phân thập phân: điểso61so/ lương/...
    float fNumber = 9.99f;
    double dNumber = 35.888d;


    // ky tự: char
    //dai dien 1 ky tu
    char c= 'm';

    // logic: boolean
    boolean status = true;
    boolean status1 = false;

    // II - Kieu du lieu tham chieu (Reference Type)
    // string - chuoi ky tu
    //Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));

    // interface
    WebDriver driver;
    JavascriptException jsExcutor;




    // Object
    Object name = "Automation";
    int[] studentage = {15,28,8};
    String[] studentname = {"Automation", "Testing"};
    // Array
    // Collection: List/ Set/ Queue

    String nametoi="Lang";



    // khai bao 1 biến de luu tru 1 loai du lieu
    // access modifier: phạm vi truy cap (public/private/protected/default)
    // kieu du lieu
    //ten bien
    // gia tri cua bien - gan vao vs phep
    //

    int studentNumber = 200;

}
