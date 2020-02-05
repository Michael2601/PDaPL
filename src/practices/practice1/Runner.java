package practices.practice1;

import utils.GlobalUtil;

import java.util.Scanner;

/**
 * @author Michael Sheshilov
 * <p>Вывести внизу фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.</p>
 * <p>Добавить комментарии в программы в виде \/** комментарий *\/, сгенерировать html-файл документации.</p>
 * <p>Ввод производится с консоли.</p>
 * <p>Вариант 27</p>
 * <p>Посчитать количество единичных битов числа.</p>
 */
public class Runner {
    public static void main(String[] args) {
        long number = getLong();
        System.out.println("Binary view : " + Long.toBinaryString(number));
        System.out.println("# of unit bits : " + bitCounter(number));
        GlobalUtil.postScriptum("Michael Sheshilov", "05.02.2020 18:00");
    }

    /**
     * <p>Сounts the number of single bits in the binary representation of a decimal number</p>
     *
     * @param number decimal number
     * @return Number of unit bits
     */
    private static int bitCounter(long number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }

    /**
     * <p>Get long number from keyboard input</p>
     *
     * @return Long number
     */
    private static long getLong() {
        Scanner input = new Scanner(System.in);
        long number;
        while (true) {
            System.out.print("Input a number: ");
            if (input.hasNextLong())
                number = input.nextInt();
            else {
                System.out.println("Incorrect input!");
                input.next();
                continue;
            }
            input.close();
            break;
        }
        return number;
    }
}
