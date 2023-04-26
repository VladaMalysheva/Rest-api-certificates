package com.epam.esm.repository.daoInterfaces;

import java.util.List;

public interface EntityDaoInterface<T>{
    public boolean save(T entity);
    public T getById(int id);
    public List<T> getAll();
    public boolean delete(int id);

}
