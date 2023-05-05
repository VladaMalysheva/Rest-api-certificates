package com.epam.esm.service;

import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.entities.GiftCertificate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GiftCertificateServiceImplTest {



    @Mock
    private GiftCertificateDao dao;
    private GiftCertificateService service;

    @BeforeEach
    public void setUp() {
        service = new GiftCertificateServiceImpl(dao);
    }

    @Test
    void save() {
        GiftCertificate certificate = new GiftCertificate("Test Certificate", "Test description", 12.00f, 5, null, null);
    service.save(certificate);


    }

    @Test
    void getById() throws SQLException {
        //when
        service.getById(7);
        //then
        verify(dao).getById(7);
    }

    @Test
    void getAll() throws SQLException {
        //when
        service.getAll("asc");
        //then
        verify(dao).getAll("asc");
    }

    @Test
    void delete() throws SQLException {
        service.delete(1);
        verify(dao).delete(1);
    }

    @Test
    void update() throws SQLException {
        GiftCertificate certificate = new GiftCertificate("Test Certificate", "Test description", 12.00f, 5, null, null);
        when(dao.update(certificate)).thenReturn(true);

        boolean result = service.update(certificate);

        assertTrue(result);
        verify(dao, times(1)).update(certificate);
    }

    @Test
    void getByDescriptionOrName() throws SQLException {
        service.getByDescriptionOrName("example of description", "asc");
        verify(dao).getByDescriptionOrName("example of description", "asc");
    }

    @Test
    void getByTag() throws SQLException {

        service.getByTagName("name", "asc", "description");
        verify(dao).getByTagName("name", "asc");
        verify(dao).getByDescriptionOrName("description", "asc");

        service.getByTagName("name2", "asc", null);
        verify(dao).getByTagName("name2", "asc");
        verify(dao, never()).getByDescriptionOrName(null, "asc");

    }

}