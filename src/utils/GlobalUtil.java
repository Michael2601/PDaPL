package utils;

import java.util.Date;

public class GlobalUtil {
    /**
     * <p>Get long number from keyboard input</p>
     *
     * @param author         Full name
     * @param acceptanceTime Time of task acceptance in format "dd.mm.YYYY HH:MM"
     */
    public static void postScriptum(String author, String acceptanceTime) {
        System.out.printf("%s %s \t %s %s\t %s %td.%<tm.%<tY %<tR ",
                "\u00A9", author, "Task acceptance time:", acceptanceTime, "Turnaround time:", new Date());
    }
}
