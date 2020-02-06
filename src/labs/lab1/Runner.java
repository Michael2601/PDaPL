package labs.lab1;

import utils.GlobalUtil;

import java.util.Scanner;

/**
 * @author Michael Sheshilov
 * <p>1. Программа, в которой перебираются числа от 1 до 500 и выводятся на экран. Если
 * число делится на 5, то вместо него выводится слово fizz, если на 7, то buzz. Если число
 * делится на 5 и на 7, то выводить слово fizzbuzz.</p>
 * <p>2. Программа, в которой все переданные во входную строку аргументы выводятся
 * на экран в обратной порядке. Например, если было передано 2 аргумента – make install, то
 * на экран должно вывестись llatsni ekam.</p>
 * <p>3. Создайте программу, вычисляющую числа Фибоначчи. Числа Фибоначчи –
 * последовательность чисел, в котором каждое следующее число равно сумме двух предыдущих.</p>
 * <p>4. Создайте программу, вычисляющую факториал целого числа.</p>
 * <p>D приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время
 * получения задания, а также дату и время сдачи задания.
 * Добавить комментарии в программы в виде \/**комментарий*\/ сгенерировать html-файл
 * документации.В заданиях на числа объект можно создавать в виде массива символов.
 * Ввести n чисел с консоли.</p>
 * <p><strong>Вариант 27</strong></p>
 * Даны две переменные целого типа: A и B. Если их значения не равны, то
 * присвоить каждой переменной большее из этих значений, а если равны, то присвоить
 * переменным нулевые значения. Вывести новые значения переменных A и B.
 */

public class Runner {
    public static void main(String[] args) {
        boolean cycleBool = true;
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n", "1. Divisibility", "2. Reverse", "3. Fibonacci", "4. Factorial", "5. Individual task", "6. Exit");
        while (cycleBool) {
            switch (GlobalUtil.getNumber(sc)) {
                case 1:
                    System.out.println("Divisibility\nEnter 2 numbers for check their Divisibility");
                    fizzbuzz(GlobalUtil.getNumber(sc), GlobalUtil.getNumber(sc));
                    break;
                case 2:
                    System.out.println("Reverse\nEnter string for reverse:");
                    sc.nextLine();
                    reverse(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Fibonacci\nEnter number for fibonacci numbers:");
                    fibonacci(GlobalUtil.getNumber(sc));
                    break;
                case 4:
                    System.out.println("Factorial\nEnter number for factorial:");
                    factorial(GlobalUtil.getNumber(sc));
                    break;
                case 5:
                    System.out.println("Individual task\nEnter 2 numbers:");
                    individualTask(GlobalUtil.getNumber(sc), GlobalUtil.getNumber(sc));
                    break;
                case 6:
                    cycleBool = false;
                    sc.close();
                    GlobalUtil.postScriptum("Michael Sheshilov", "06.02.2020 22:30");
                    break;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
        }
    }

    /**
     * <p>Checking the divisibility of numbers from 1 to 500 by 2 divisors entered</p>
     *
     * @param firstDivider  the first number on which divisibility will be checked
     * @param secondDivider the second number on which divisibility will be checked
     */
    private static void fizzbuzz(int firstDivider, int secondDivider) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 500; i++) {
            if (i % firstDivider == 0 && i % secondDivider == 0)
                str.append(" fizzbuzz");
            else if (i % firstDivider == 0)
                str.append(" fizz");
            else if (i % secondDivider == 0)
                str.append(" buzz");
            else
                str.append(" ").append(i);
        }
        System.out.println(str.toString());
    }

    /**
     * <p>Output reverse string</p>
     *
     * @param str string to reverse
     */
    private static void reverse(String str) {
        for (int i = str.length() - 1; i >= 0; i--)
            System.out.print(str.charAt(i));
        System.out.println();
    }

    /**
     * <p>Output factorial to number</p>
     *
     * @param last number on which stop calculate
     */
    private static void factorial(int last) {
        long result = 1;
        for (int i = 1; i <= last; i++) {
            result *= i;
        }
        System.out.println(result);
    }

    /**
     * <p>Output fibonacci numbers</p>
     *
     * @param n number of iteration
     */
    private static void fibonacci(int n) {
        int n1 = 0, n2 = 1, n3;
        System.out.print("1 ");
        for (int i = 1; i < n; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    /**
     * <p>Compares and changes the meaning of equality and inequality</p>
     *
     * @param a first number for comparison
     * @param b first number for comparison
     */
    private static void individualTask(int a, int b) {
        int max = Math.max(a, b);
        if (a != b) {
            a = max;
            b = max;
        } else {
            a = 0;
            b = 0;
        }
        System.out.printf("A = %d\tB = %d", a, b);
    }


}
