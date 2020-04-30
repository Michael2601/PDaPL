package practices.practice2;

import utils.GlobalUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Michael Sheshilov
 * <p><strong>Вариант 27</strong></p>
 * <p>Сгенерировать 20 случайных целых чисел в диапазоне от -5 до 4, записать их в ячейки массива.
 * Посчитать сколько среди них положительных, отрицательных и нулевых значений. Вывести на экран
 * элементы массива и посчитанные количества.</p>
 * <p>Выяснить, какое число встречается в какой строке раньше - положительное или отрицательное</p>
 */
public class Runner {
    private static final int COUNT_NUM = 20;
    private static final int FROM = -5;
    private static final int TO = 4;

    public static void main(String[] args) {
        boolean cycleBool = true;
        Scanner sc = new Scanner(System.in);
        System.out.printf("""
                %s
                %s
                %s
                """, "1. Individual task 1", "2. Individual task 2", "3. Exit");
        while (cycleBool) {
            switch (GlobalUtil.getNumber(sc)) {
                case 1:
                    System.out.println("Individual task 1\n");
                    int[] arr = new Random(System.currentTimeMillis()).ints(COUNT_NUM, FROM, TO).toArray();
                    Arrays.stream(arr).forEach(s -> System.out.print(s + " "));

                    System.out.println("\nNumber of positive = " + Arrays.stream(arr).filter(s -> s > 0).count());
                    System.out.println("Number of negative = " + Arrays.stream(arr).filter(s -> s < 0).count());
                    System.out.println("Number of zero = " + Arrays.stream(arr).filter(s -> s == 0).count());
                    break;
                case 2:
                    System.out.println("Individual task 2\nEnter rows and columns:");
                    individualTask2(createArray(sc, GlobalUtil.getNumber(sc), GlobalUtil.getNumber(sc)));
                    break;
                case 3:
                    cycleBool = false;
                    sc.close();
                    GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
                    break;
                default:
                    System.out.println("Incorrect number");
                    break;
            }
        }
    }

    /**
     * <p>Output which number is earlier positive or negative in each row</p>
     *
     * @param arr array for task
     */
    private static void individualTask2(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i][0] > 0)
                System.out.printf("In %d row positive number has met before.\n", i + 1);
            else if (arr[i][0] < 0)
                System.out.printf("In %d row negative number has met before.\n", i + 1);
            else
                System.out.printf("In %d row zero has met before.\n", i + 1);
    }

    /**
     * <p>Filling a two-dimensional array</p>
     *
     * @param input   Scanner object
     * @param rows    number of rows in array
     * @param columns number of columns in array
     */
    private static int[][] createArray(Scanner input, int rows, int columns) {
        int[][] arr = new int[rows][columns];
        System.out.println("Filling array:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                arr[i][j] = GlobalUtil.getNumber(input);
            }
        return arr;
    }
}
