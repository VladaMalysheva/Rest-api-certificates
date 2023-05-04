package com.epam.esm.service;

import com.epam.esm.errorHandling.DbException;
import com.epam.esm.repository.entities.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagService {
    public boolean save(Tag entity) throws DbException;

    public Tag getById(int id) throws DbException;

    public List<Tag> getAll() throws DbException;

    public boolean delete(int id) throws DbException;
}
