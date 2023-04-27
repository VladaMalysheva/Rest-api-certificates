package com.epam.esm.service;

import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.daoInterfaces.TagDao;
import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftCertificateServiceImpl implements GiftCertificateService{

    @Autowired
    private GiftCertificateDao dao;

    public GiftCertificateServiceImpl(GiftCertificateDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean save(GiftCertificate entity) {
        return dao.save(entity);
    }

    @Override
    public GiftCertificate getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<GiftCertificate> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(GiftCertificate entity) {
        return dao.update(entity);
    }
}
