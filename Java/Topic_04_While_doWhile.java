import zmq.io.net.tcp.TcpAddress;

import java.util.Arrays;
import java.util.Scanner;

public class Topic_04_While_doWhile {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int enter1 = scanner.nextInt();
        // int enter2 = scanner.nextInt();
        //  TC_01_While(enter1);
        //TC_02_While(enter1, enter2);
        //TC_03_While(enter1);
        TC_06_While(enter1);
    }

    public static void TC_01_While(int enter) {
        while (enter <= 100) {
            if (enter % 2 == 0) {
                System.out.println("args = " + enter);
            }
            enter++;

        }

    }

    public static void TC_02_While(int enter1, int enter2) {
        while (enter1 <= enter2) {
            if (enter1 % 3 == 0 && enter1 % 5 == 0) {
                System.out.println("enter1 = " + enter1);
            }
            enter1++;
        }

    }

    public static void TC_03_While(int enter1) {
        int i = 0;
        while (0 < enter1) {

            if (enter1 % 2 != 0) {
                i += enter1;
            }
            enter1--;
        }
        System.out.println("enter1 = " + i);


    }

    public static void TC_06_While(int enter1) {
        int i = 1;
        while (0 < enter1) {
            i *= enter1;
            enter1--;
        }
        System.out.println("enter1 = " + i);


    }

}
