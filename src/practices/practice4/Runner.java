package practices.practice4;

import org.jetbrains.annotations.NotNull;
import utils.GlobalUtil;

import java.util.Scanner;
import java.util.regex.Pattern;

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
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println(createRegex(sc).matcher(text.toLowerCase()).results().count());
        sc.close();
        GlobalUtil.postScriptum("Michael Sheshilov", "06.02.2020 22:30");
    }

    @NotNull
    private static Pattern createRegex(@NotNull Scanner input) {
        System.out.print("Enter a word: ");
        return Pattern.compile("\\b" + input.next().toLowerCase().replaceAll("[ёе]", "[ёе]")
                .replaceAll("[йи]", "[йи]") + "\\b", Pattern.CASE_INSENSITIVE);

    }
}
