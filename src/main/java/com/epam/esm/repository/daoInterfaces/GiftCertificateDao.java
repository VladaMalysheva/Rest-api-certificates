package com.epam.esm.repository.daoInterfaces;

import com.epam.esm.repository.entities.GiftCertificate;


public interface GiftCertificateDao extends EntityDao<GiftCertificate> {
    public boolean update(GiftCertificate entity);
}
