package practices.practice5;

import java.io.*;

/**
 * @author Michael Sheshilov
 */
public class Task3 {

    public void runTask() throws IOException {
        File file = new File("files/practice5/in/task3/java.txt");
        File resultFile = new File("files/practice5/out/task3/java.txt");


        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.append(reverse(line)).append(System.lineSeparator());
                }
            }
        }
    }

    private static StringBuilder reverse(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
                newString.append(str.charAt(i));
            }
        return newString;
    }
}
