package labs.lab4.dao;

import labs.lab4.model.Month;
/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public interface ModelDAO {
    int create(Month month);
    Month readByPersonalId(int personalId);
    Month readBySystemlId(int systemId);
    void update(Month month);
    void delete(int id);
}
