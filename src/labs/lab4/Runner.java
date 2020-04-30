package labs.lab4;

import labs.lab4.dao.DAOFactory;
import labs.lab4.dao.ModelDAO;
import labs.lab4.model.Month;
import labs.lab4.model.Year;
import utils.GlobalUtil;

/**
 * @author Michael Sheshilov
 *
 * <p><strong>Вариант 27</strong></p>
 * Для заданий варианта в лабораторной работе 2 создать базу данных для хранения
 * информации. Определить класс для организации соединения (пула соединений). Создать
 * классы для выполнения соответствующих заданию запросов в БД.
 */
public class Runner {

    public static void main(String[] args) {
        Year year = new Year();
        year.addMonth(1, "January", -4.6);
        year.addMonth(2, "February", -1.6);
        year.addMonth(3, "March", 2.8);
        year.addMonth(4, "April", 7.6);
        year.addMonth(5, "May", 14);
        year.addMonth(6, "June", 17);
        year.addMonth(7, "July", 18.5);
        year.addMonth(8, "August", 18.5);
        year.addMonth(9, "September", 13.3);
        year.addMonth(10, "October", 6.5);
        year.addMonth(11, "November", 1.8);
        year.addMonth(12, "December", -0.5);

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");

        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ModelDAO modelDAO = mysqlFactory.getModelDAO();
        System.out.println(year.getMonths().stream().findFirst().orElse(null));

        int systemId = modelDAO.create(year.getMonths().stream().findFirst().orElse(null));
        System.out.println("Student's system id = " + systemId);
        Month month1 = modelDAO.readBySystemlId(systemId);
        System.out.println("after create: " + month1);
        month1.setAvgT(-20);
        modelDAO.update(month1);
        Month month2 = modelDAO.readBySystemlId(systemId);
        System.out.println("after update: " + month2);
        modelDAO.delete(month2.getMonthId());

        System.out.println("---------------------------------");
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
