package practices.practice5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("ALL")
public class Task1 {
    private static final int COUNT_NUM = 20;
    private static final int FROM = -50;
    private static final int TO = 40;

    static Path file = Paths.get("files/practice5/in/task1/random.txt");
    static Path resultFile = Paths.get("files/practice5/out/task1/sorted.txt");

    public static void fileWithRandomValues() {
        List<String> randomNum = getRandomStringListOfNum();

        try {
            Files.write(file, randomNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getRandomStringListOfNum() {
        List<String> random = new Random(System.currentTimeMillis()).ints(COUNT_NUM, FROM, TO).mapToObj(e->Integer.toString(e)).collect(Collectors.toList());
        return random;
    }

    public static void getSortedNum() {
        try {
            List<String> listOfNumbers = Files.readAllLines(file);
            listOfNumbers.sort(Comparator.comparing(Integer::valueOf));
            Files.write(resultFile, listOfNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
