package labs.lab4.dao;


import labs.lab4.model.Month;

import java.sql.*;

import static labs.lab4.dao.MysqlDAOFactory.TABLE_NAME;

/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("ALL")
public class MysqlModelDAO implements ModelDAO {
    private static final String CREATE_QUERY = String.format("insert into %s (month_id, name, average_temperature) values (?,?,?)",TABLE_NAME);
    private static final String READ_BY_PERSONAL_ID_QUERY = String.format("SELECT month_id,  name, average_temperature FROM %s WHERE month_id = ?",TABLE_NAME);
    private static final String UPDATE_QUERY = String.format("UPDATE %s SET month_id=?, name=?, average_temperature=? WHERE month_id = ?",TABLE_NAME);
    private static final String READ_BY_SYSTEM_ID_QUERY = String.format("SELECT month_id, name, average_temperature FROM %s WHERE id = ?",TABLE_NAME);
    private static final String DELETE_QUERY = String.format("DELETE FROM %s WHERE month_id = ?",TABLE_NAME);

    @Override
    public int create(Month month) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, month.getMonthId());
            preparedStatement.setString(2, month.getName());
            preparedStatement.setDouble(3, month.getAvgT());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println("Error - closing result:" + rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println("Error - closing prepared statement" + sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
        return -1;
    }
    @Override
    public Month readByPersonalId(int monthId) {
        Month month = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_BY_PERSONAL_ID_QUERY);
            preparedStatement.setInt(1, monthId);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            if (result.next() && result != null) {
                month = new Month();
                month.setMonthId(result.getInt(1));
                month.setName(result.getString(2));
                month.setAvgT(result.getDouble(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
        return month;
    }
    @Override
    public void update(Month month) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, month.getMonthId());
            preparedStatement.setString(2, month.getName());
            preparedStatement.setDouble(3, month.getAvgT());
            preparedStatement.setInt(4, month.getMonthId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }
    @Override
    public void delete(int personalId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, personalId);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
    }

    @Override
    public Month readBySystemlId(int systemId) {
        Month month = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MysqlDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_BY_SYSTEM_ID_QUERY);
            preparedStatement.setInt(1, systemId);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            if (result.next() && result != null) {
                month = new Month();
                month.setMonthId(result.getInt(1));
                month.setName(result.getString(2));
                month.setAvgT(result.getDouble(3));
            } else {
                // TODO
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                System.out.println(cse.getMessage());
            }
        }
        return month;
    }
}
