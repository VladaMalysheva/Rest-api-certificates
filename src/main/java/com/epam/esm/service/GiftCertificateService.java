package com.epam.esm.service;

import com.epam.esm.errorHandling.DbException;
import com.epam.esm.repository.entities.GiftCertificate;

import java.util.List;


public interface GiftCertificateService {
    public boolean save(GiftCertificate entity) throws DbException;

    public GiftCertificate getById(int id) throws DbException;

    public List<GiftCertificate> getAll(String sort) throws DbException;

    public boolean delete(int id) throws DbException;

    public boolean update(GiftCertificate entity) throws DbException;

    public List<GiftCertificate> getByTagName(String name, String sort, String description) throws DbException;


    public List<GiftCertificate> getByDescriptionOrName(String description, String sort) throws DbException;
}
