package labs.lab4.dao;
/**
 * @author Michael Sheshilov
 */
public abstract class DAOFactory {
    public static final int MYSQL = 0;
    public abstract ModelDAO getModelDAO();
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public static DAOFactory getDAOFactory(int database) {
        return switch (database) {
            case MYSQL -> new MysqlDAOFactory();
            default -> null;
        };
    }
}
