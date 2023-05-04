package com.epam.esm.repository.daoInterfaces;

import com.epam.esm.repository.entities.GiftCertificate;

import java.sql.SQLException;
import java.util.List;


public interface GiftCertificateDao extends EntityDao<GiftCertificate> {
    public boolean update(GiftCertificate entity) throws SQLException;

    public List<GiftCertificate> getByTagName(String name, String sort) throws SQLException;

    public List<GiftCertificate> getAll(String sort) throws SQLException;

    public List<GiftCertificate> getByDescriptionOrName(String description, String sort) throws SQLException;
}
