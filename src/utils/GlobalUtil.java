package utils;

import java.util.Date;
import java.util.Scanner;

public class GlobalUtil {
    /**
     * <p>Output Post Scriptum</p>
     *
     * @param author         Full name
     * @param acceptanceTime Time of task acceptance in format "dd.mm.YYYY HH:MM"
     */
    public static void postScriptum(String author, String acceptanceTime) {
        System.out.printf("%s %s \t %s %s\t %s %td.%<tm.%<tY %<tR ",
                "\u00A9", author, "Task acceptance time:", acceptanceTime, "Turnaround time:", new Date());
    }

    /**
     * <p>Get Int number from keyboard input</p>
     *
     * @param input Scanner object
     * @return Int number
     */
    public static int getNumber(Scanner input) {
        int number = 6;
        try {
            while (true) {
                System.out.print("Input a number: ");
                if (input.hasNextInt())
                    number = input.nextInt();
                else {
                    System.out.println("Incorrect input!");
                    input.next();
                    continue;
                }
                break;
            }
        } catch (Exception ignored) { }
        return number;
    }
}

