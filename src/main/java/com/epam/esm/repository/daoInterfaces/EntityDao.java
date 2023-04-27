package com.epam.esm.repository.daoInterfaces;

import java.util.List;

public interface EntityDao<T>{
    public boolean save(T entity);
    public T getById(int id);
    public List<T> getAll();
    public boolean delete(int id);

}
