package com.epam.esm.repository.daoInterfaces;

import com.epam.esm.repository.entities.GiftCertificate;

import java.util.List;


public interface GiftCertificateDao extends EntityDao<GiftCertificate> {
    public boolean update(GiftCertificate entity);

    public List<GiftCertificate> getByTagName(String name, String sort);

    public List<GiftCertificate> getAll(String sort);

    public List<GiftCertificate> getByDescriptionOrName(String description, String sort);
}
