package com.epam.esm.service;

import com.epam.esm.repository.daoInterfaces.TagDao;
import org.junit.jupiter.api.BeforeEach;
import com.epam.esm.repository.entities.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @Mock
    private TagDao dao;
    private TagService service;

    @BeforeEach
    public void setUp() {
        service = new TagServiceImpl(dao);
    }

    @Test
    void save() throws SQLException {
        Tag tag = new Tag("tag1");
        //when
        service.save(tag);
        //then
        verify(dao).save(tag);
    }

    @Test
    void getById() throws SQLException {
        //when
        service.getById(1);
        //then
        verify(dao).getById(1);
    }

    @Test
    void getAll() throws SQLException {
        service.getAll();
        verify(dao).getAll();
    }

    @Test
    void delete() throws SQLException {
        service.delete(1);
        verify(dao).delete(1);
    }
}