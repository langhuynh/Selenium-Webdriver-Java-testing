import webdriver.Topic_06_WebDriver_Commands_01;

import java.util.Arrays;

public class Topic_05_Array {
    static int[] number = {5,8,15,7,60,10};
    public static void main(String[] args){
        TC_01_Find_Max_Number();
        TC_02_Sum_first_And_Last();
        TC_03_Even_Number();
        TC_04_Sum_Odd_Number();

        //split: tách 1 chuoi thanh 1 mang ki tu/ chuoi ki tu
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");
        for(String string : results){
            System.out.println(results[1]);
        }
        //replace
    }
    public static void TC_01_Find_Max_Number(){
        int x=0;
        for (int i = 0; i<number.length;i++){
            if(x<number[i]){
                x=number[i];
            }
        }
        System.out.println(x);

    }
    public static void TC_02_Sum_first_And_Last(){
        int x=0;
        for (int i = 0; i<number.length;i++){
                x=number[0] + number[number.length-1];
        }
        System.out.println(x);

    }
    public static void TC_03_Even_Number(){
        int x=0;
        for (int i = 0; i < number.length; i++){
            if (number[i]%2==0){
                System.out.println("Even number: " + number[i]);
            }
        }
    }
    public static void TC_04_Sum_Odd_Number(){
        int x=0;
        for (int i = 0; i < number.length; i++){
            if (number[i] % 2 != 0 && number[i]>0){
                x += number[i];

            }

        }
        System.out.println("Sum odd of number: " + x);
    }



}
