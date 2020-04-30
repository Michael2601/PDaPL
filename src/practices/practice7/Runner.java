package practices.practice7;

import utils.GlobalUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Michael Sheshilov
 *
 * <p><strong>Вариант 27</strong></p>
 * Год. Определить иерархию года. Создать несколько объектов-месяцев. Собрать
 * год. Провести сортировку месяцев в году на основе средней температуры. Найти месяц в
 * году, соответствующий заданному диапазону температур.
 */
public class Runner {
    public static void main(String[] args) {
        String sqlQuery;

        Year year = new Year();
        year.addMonth("January", -4.6);
        year.addMonth("February", -1.6);
        year.addMonth("March", 2.8);
        year.addMonth("April", 7.6);
        year.addMonth("May", 14);
        year.addMonth("June", 17);
        year.addMonth("July", 18.5);
        year.addMonth("August", 18.5);
        year.addMonth("September", 13.3);
        year.addMonth("October", 6.5);
        year.addMonth("November", 1.8);
        year.addMonth("December", -0.5);

        try {
            DBConnect.createDB(DBConnect.DB_NAME);
            String createTable = String.format("""
                    CREATE TABLE %s.%s
                    (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(30) NOT NULL,
                    average_temperature FLOAT(11) NOT NULL);
                    """, DBConnect.DB_NAME, DBConnect.TABLE_NAME);
            DBConnect.runStatement(SQLStatemntType.NON_SELECT, createTable);

            for (Month month : year.getMonths()) {
                sqlQuery = String.format("INSERT INTO %s.%s (name, average_temperature) values('%s',",
                        DBConnect.DB_NAME, DBConnect.TABLE_NAME, month.getName())
                        + month.getAvgT() + ");";
                DBConnect.runStatement(SQLStatemntType.NON_SELECT, sqlQuery);
            }
            sqlQuery = String.format("SELECT * FROM %s.%s;", DBConnect.DB_NAME, DBConnect.TABLE_NAME);
            ResultSet rs = DBConnect.runStatement(SQLStatemntType.SELECT, sqlQuery);
            DBConnect.printResultSet(rs);
        } catch (SQLException e) {
            System.out.println("getting exception :" + e);
        } finally {
            DBConnect.closeConnection();
        }


        System.out.println("---------------------------------");


        year.getMonths().forEach(System.out::println);

        System.out.println("---------------------------------");

        year.sortByAverageTemperature(true);
        year.getMonths().forEach(System.out::println);

        System.out.println("---------------------------------");

        year.getMonthsRangeByAverageTemperature(-1.6, 6.5).forEach(System.out::println);

        GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
    }
}
