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
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
        //when
        service.getAll("asc");
        //then
        verify(dao).getAll("asc");
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
        GiftCertificate certificate = new GiftCertificate("Test Certificate", "Test description", 12.00f, 5, null, null);
        when(dao.update(certificate)).thenReturn(true);

        boolean result = service.update(certificate);

        assertTrue(result);
        verify(dao, times(1)).update(certificate);
    }

    @Test
    void getByDescriptionOrName() {
    }

}