package com.epam.esm.service;

import com.epam.esm.repository.entities.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagService {
    public boolean save(Tag entity);

    public Tag getById(int id);

    public List<Tag> getAll();

    public boolean delete(int id);
}
