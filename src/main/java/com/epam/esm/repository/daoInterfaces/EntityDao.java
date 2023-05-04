package com.epam.esm.repository.daoInterfaces;
import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T>{
    public boolean save(T entity) throws SQLException;
    public T getById(int id) throws SQLException;
    public boolean delete(int id) throws SQLException;

}
