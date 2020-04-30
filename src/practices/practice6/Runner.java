package practices.practice6;

import utils.GlobalUtil;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Michael Sheshilov
 * <p><strong>Вариант 27</strong></p>
 * Для заданий варианта 12-25 на основе решенного задания ЛР2 организовать
 * синхронизированный доступ к ресурсам (файлам). Для каждого процесса
 * создать отдельный поток выполнения.
 */
public class Runner {
    public static void main(String[] args) {
        Year year = new Year();
        System.out.println();
        CreateInOtherThread thread1 = new CreateInOtherThread(year, "January", -4.6);
        CreateInOtherThread thread2 = new CreateInOtherThread(year, "February", -1.6);
        CreateInOtherThread thread3 = new CreateInOtherThread(year, "March", 2.8);
        CreateInOtherThread thread4 = new CreateInOtherThread(year, "April", 7.6);
        CreateInOtherThread thread5 = new CreateInOtherThread(year, "May", 14);
        CreateInOtherThread thread6 = new CreateInOtherThread(year, "June", 17);
        CreateInOtherThread thread7 = new CreateInOtherThread(year, "July", 18.5);
        CreateInOtherThread thread8 = new CreateInOtherThread(year, "August", 18.5);
        CreateInOtherThread thread9 = new CreateInOtherThread(year, "September", 13.3);
        CreateInOtherThread thread10 = new CreateInOtherThread(year, "October", 6.5);
        CreateInOtherThread thread11 = new CreateInOtherThread(year, "November", 1.8);
        CreateInOtherThread thread12 = new CreateInOtherThread(year, "December", -0.5);

        System.out.println("Threads work Start\n");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
            thread12.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("""

                Threads work Done
                """);

        year.getMonths().forEach(System.out::println);

        System.out.println("---------------------------------");

        year.sortByAverageTemperature(true);
        year.getMonths().forEach(System.out::println);

        System.out.println("---------------------------------");

        year.getMonthsRangeByAverageTemperature(-1.6, 6.5).forEach(System.out::println);

        GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
    }

    static class CreateInOtherThread extends Thread {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        private final LinkedBlockingQueue<Year> results = new LinkedBlockingQueue<>();
        private Year year;
        private final String name;
        private final double avgT;

        public CreateInOtherThread(Year year, String name, double avgT) {
            this.year = year;
            this.name = name;
            this.avgT = avgT;
        }

        @Override
        public synchronized void run() {
            year.addMonth(name, avgT);
            try {
                results.put(year);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
