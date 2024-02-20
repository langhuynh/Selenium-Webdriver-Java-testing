package javaTester;

import java.util.Arrays;
import java.util.Random;

public class Topic_06_Random {
    //Java builtin cung cap san, lay ra su dung
   public static void main(String[] args) {
       Random rand = new Random();
       System.out.println(rand.nextInt());
       System.out.println(rand.nextInt());

       System.out.println(rand.nextDouble());
       System.out.println(rand.nextFloat());
       System.out.println(rand.nextBoolean());

       System.out.println("Automation" + rand.nextInt(99999) + "@email.net");
       System.out.println("Automation" + rand.nextInt(99999) + "@email.net");

       System.out.println("Automation" + rand.nextInt(99999) + "@email.net");

       System.out.println("Automation" + rand.nextInt(99999) + "@email.net");


   }

}
