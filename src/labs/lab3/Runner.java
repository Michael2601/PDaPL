package labs.lab3;

import utils.GlobalUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
/**
 * @author Michael Sheshilov
 * <p><strong>Вариант 27</strong></p>
 * <p>Не используя вспомогательных объектов, переставить отрицательные элементы данного
 * списка в конец, а положительные – в начало списка.</p>
 */
public class Runner {
    private static final int COUNT_NUM = 15;
    private static final int FROM = -15;
    private static final int TO = 15;

    public static void main(String[] args) {
        List<Integer> list = new Random(System.currentTimeMillis()).ints(COUNT_NUM, FROM, TO).boxed().collect(Collectors.toList());
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();
        list.stream().sorted((x, y) -> (y - x)).forEach(s -> System.out.print(s + " "));
        GlobalUtil.postScriptum("Michael Sheshilov", "06.02.2020 22:30");
    }
}
