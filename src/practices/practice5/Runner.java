package practices.practice5;

import utils.GlobalUtil;

import java.io.IOException;

/**
 * @author Michael Sheshilov
 *
 * <p><strong>Вариант 27</strong></p>
 * 1. Создать и заполнить файл случайными целыми числами. Отсортировать
 * содержимое файла по возрастанию.
 * 2. Прочитать текст Java-программы и все слова public в объявлении атрибутов и
 * методов класса заменить на слово private.
 * 3. Прочитать текст Java-программы и записать в другой файл в обратном порядке
 * символы каждой строки
 */
public class Runner {
    public static void main(String[] args) {
       Task1.fileWithRandomValues();
        Task1.getSortedNum();


        Task2 task2 = new Task2();
        try {
            task2.runTask();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Task3 task3 = new Task3();
        try {
            task3.runTask();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
    }
}
