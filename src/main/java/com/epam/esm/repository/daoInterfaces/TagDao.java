package com.epam.esm.repository.daoInterfaces;

import com.epam.esm.repository.entities.Tag;

import java.util.List;


public interface TagDao extends EntityDao<Tag> {

    public List<Tag> getAll();
}
