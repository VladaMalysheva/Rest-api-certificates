package com.epam.esm.repository.daoImplementation;

import com.epam.esm.config.MVCconfig;
import com.epam.esm.config.TestConfig;
import com.epam.esm.repository.entities.GiftCertificate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.BeforeEach;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class GiftCertificateDaoImplTest {

    private GiftCertificateDaoImpl dao;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setUp() {
        dao = new GiftCertificateDaoImpl(dataSource);
    }


    @Test
    void save() {
        dao.save(new GiftCertificate("vlada", "this is test description", 17, 2, null, null));

     }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getByTagName() {
    }

    @Test
    void getByDescriptionOrName() {
    }
}