package com.epam.esm.service;

import com.epam.esm.repository.entities.GiftCertificate;

import java.util.List;


public interface GiftCertificateService {
    public boolean save(GiftCertificate entity);

    public GiftCertificate getById(int id);

    public List<GiftCertificate> getAll(String sort);

    public boolean delete(int id);

    public boolean update(GiftCertificate entity);

    public List<GiftCertificate> getByTagName(String name, String sort, String description);


    public List<GiftCertificate> getByDescriptionOrName(String description, String sort);
}
