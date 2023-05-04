package com.epam.esm.service;

import com.epam.esm.errorHandling.DbException;
import com.epam.esm.repository.daoInterfaces.TagDao;
import com.epam.esm.repository.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao dao;

    public TagServiceImpl(TagDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean save(Tag entity) throws DbException {
        try {
            return dao.save(entity);
        } catch (SQLException e) {
            throw new DbException("Can't save tag with id " + entity.getId() +" to the database", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Tag getById(int id) throws DbException {
        try {
            return dao.getById(id);
        } catch (SQLException e) {
            throw new DbException("Can't get tag with id "+ id +" from the database", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Tag> getAll() throws DbException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            throw new DbException("Can't get all tags from the database", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public boolean delete(int id) throws DbException {
        try {
            return dao.delete(id);
        } catch (SQLException e) {
            throw new DbException("Can't delete tag with id "+ id +" from the database", HttpStatus.NOT_FOUND);
        }
    }
}
