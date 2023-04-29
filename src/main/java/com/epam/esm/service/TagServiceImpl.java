package com.epam.esm.service;

import com.epam.esm.repository.daoInterfaces.TagDao;
import com.epam.esm.repository.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao dao;

    public TagServiceImpl(TagDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean save(Tag entity) {
        return dao.save(entity);
    }

    @Override
    public Tag getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Tag> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }
}
