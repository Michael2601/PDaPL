package labs.lab3;

import utils.GlobalUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Runner {
    private static final int COUNT_NUM = 15;
    private static final int FROM = -15;
    private static final int TO = 15;

    private static List<Integer> list;

    public static void main(String[] args) {
        list = new Random(System.currentTimeMillis()).ints(COUNT_NUM, FROM, TO).boxed().collect(Collectors.toList());
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();
        list.stream().sorted((x, y) -> (y - x)).forEach(s -> System.out.print(s + " "));
        GlobalUtil.postScriptum("Michael Sheshilov", "06.02.2020 22:30");
    }
}
