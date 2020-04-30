package practices.practice5;

import java.io.*;

/**
 * @author Michael Sheshilov
 */
public class Task2 {
    public static final String PUBLIC = "public";
    public static final String PRIVATE = "private";

    public void runTask() throws IOException {
        File file = new File("files/practice5/in/task2/java.txt");
        File resultFile = new File("files/practice5/out/task2/java.txt");


        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile))) {
                String line;
                while ((line=bufferedReader.readLine())!=null) {
                    bufferedWriter.append(line.replace(PUBLIC, PRIVATE)).append(System.lineSeparator());
                }
            }
        }
    }
}
