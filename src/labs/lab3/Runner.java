package labs.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    private static final int COUNT_NUM = 15;
    private static List<Integer> list = new ArrayList<>(COUNT_NUM);

    public static void main(String[] args) {
        enterList();
        printList();
        list.stream()
                .sorted((x, y) -> (y - x))
                .forEach(System.out::println);
    }

    private static void enterList() {
        Random random = new Random(System.currentTimeMillis());

        for(int i = 0; i < COUNT_NUM; i++)
        {
            int number = -1*COUNT_NUM + random.nextInt(COUNT_NUM * 2);
            list.add(number);
        }
    }
    private static void printList() {
        for (Integer aList : list) {
            System.out.print(aList + " ");
        }
        System.out.println();
    }
}
