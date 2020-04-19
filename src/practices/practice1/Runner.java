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
        Scanner sc = new Scanner(System.in);
        int number = GlobalUtil.getNumber(sc);
        sc.close();
        System.out.println("Binary view : " + Integer.toBinaryString(number));
        System.out.println("# of unit bits : " + bitCounter(number));
        GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:00");
    }

    /**
     * <p>Сounts the number of single bits in the binary representation of a decimal number</p>
     *
     * @param number decimal number
     * @return Number of unit bits
     */
    private static int bitCounter(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }
}
