package com.epam.esm.repository.daoInterfaces;

import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.entities.Tag;

public interface GiftCertificateDaoInterface extends EntityDaoInterface<GiftCertificate> {
    public boolean update(GiftCertificate entity);
}
