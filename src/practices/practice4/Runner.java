package practices.practice4;

import utils.GlobalUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Michael Sheshilov
 *
 * <p><strong>Вариант 27</strong></p>
 * Определить количество вхождений заданного слова в текст, игнорируя регистр
 * символов и считая буквы «е», «ё», и «и», «й» одинаковыми
 */
public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Arrays.stream(text.split(" ")).filter(e->e.matches()).forEach(System.out::println);
        GlobalUtil.postScriptum("Michael Sheshilov", "06.02.2020 22:30");
    }
}
