import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;
@Test
public class Topic_02_Condition_Statement_if_else {
    WebDriver driver;
    static Scanner scanner = new Scanner(System.in);
  //  @Test
    public static void main(String[] args)
    {
        int number = scanner.nextInt();
        if(number % 2 == 0){
            System.out.println("Number: " +number + " is even number");

        } else {
            System.out.println("Number: " +number + " is odd number");
        }
    }
    @Test
    public void TC_02(){
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        if (numberA>=numberB){
            System.out.println(numberA + "larger than or equal "+numberB);

        } else {
            System.out.println(numberA + "smaller than" + numberB);
        }

    }
}
