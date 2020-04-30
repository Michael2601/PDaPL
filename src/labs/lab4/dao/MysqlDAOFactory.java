package labs.lab4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Michael Sheshilov
 */
public class MysqlDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "root";

    public static final String DB_NAME = "l4";
    public static final String TABLE_NAME = "year";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true";

    private static String createStudentTable = String.format("""
            CREATE TABLE IF NOT EXISTS %s.%s (
            id int(11) NOT NULL AUTO_INCREMENT,
            month_id int(11) NOT NULL,
            name varchar(255) NOT NULL,
            average_temperature float(11) NOT NULL,
            PRIMARY KEY (id),
            UNIQUE KEY id_UNIQUE (id),
            UNIQUE KEY month_id_UNIQUE (month_id)
            ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
                    """, DB_NAME, TABLE_NAME);

    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(true);
            createTable(conn, createStudentTable);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTable(Connection conn, String sqlQuery) {
        try {
            conn.createStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelDAO getModelDAO() {
        return new MysqlModelDAO();
    }
}
