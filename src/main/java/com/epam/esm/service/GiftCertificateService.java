package com.epam.esm.service;

import com.epam.esm.repository.entities.GiftCertificate;
import org.springframework.stereotype.Component;

import java.util.List;


public interface GiftCertificateService {
    public boolean save(GiftCertificate entity);

    public GiftCertificate getById(int id);

    public List<GiftCertificate> getAll();

    public boolean delete(int id);

    public boolean update(GiftCertificate entity);
}
