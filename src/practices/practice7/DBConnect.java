package practices.practice7;

import java.sql.*;
import java.util.Properties;
/**
 * @author Michael Sheshilov
 */
public class DBConnect {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public static final String DB_NAME = "pz7";
    public static final String TABLE_NAME = "year";
    private static Connection connection;

    public static void createDB(String dbName) throws SQLException {
        dropDB(dbName);
        runStatement(SQLStatemntType.NON_SELECT, "CREATE DATABASE " + dbName);
    }

    public static void dropDB(String dbName) throws SQLException {
        runStatement(SQLStatemntType.NON_SELECT, "DROP DATABASE IF EXISTS " + dbName);
    }

    public static Connection createConnection() {
        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true";
        System.out.println("Connection Url:" + url);
        Properties prop = new Properties();
        prop.put("user", DB_USER);
        prop.put("password", DB_PASSWORD);
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Сonnection close error: " + e);
            }
        }
    }

    public static ResultSet runStatement(SQLStatemntType type, String sqlQuery) throws
            SQLException {
        ResultSet rs = null;
        Statement statement = getConnection().createStatement();
        switch (type) {
            case NON_SELECT:
                statement.executeUpdate(sqlQuery);
                break;
            case SELECT:
                rs = statement.executeQuery(sqlQuery);
                break;
            default:
                statement.execute(sqlQuery);
                break;
        }
        System.out.println("SQL query to execute = [" + sqlQuery + "] result:");
        return rs;
    }

    public static void printResultSet(ResultSet resultSetToPrint) {
        try {
            ResultSetMetaData rsmd = resultSetToPrint.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSetToPrint.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1)
                        System.out.print(" | ");
                    System.out.print(resultSetToPrint.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error printing resultSet [" + e + "]");
        }
    }
}
@SuppressWarnings("ALL")
enum SQLStatemntType {
    ANY(0), SELECT(1), NON_SELECT(2);
    private final int sqlTypeCode;

    SQLStatemntType(int sqlTypeCode) {
        this.sqlTypeCode = sqlTypeCode;
    }

    public int getSQLTypeCode() {
        return this.sqlTypeCode;
    }
}
