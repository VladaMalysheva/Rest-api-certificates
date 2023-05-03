package com.epam.esm.service;

import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.entities.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GiftCertificateServiceImpl implements GiftCertificateService{

    @Autowired
    private GiftCertificateDao dao;

    @Autowired
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
    public List<GiftCertificate> getAll(String sort) {
        return dao.getAll(sort);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(GiftCertificate entity) {
        return dao.update(entity);
    }

    @Override
    public List<GiftCertificate> getByTagName(String name, String sort, String description) {
        List<GiftCertificate> result = new ArrayList<>();
        result = dao.getByTagName(name, sort);
        System.out.println(result);
        if(description!=null){
            List<GiftCertificate> tagsWithDescriptionOrName = getByDescriptionOrName(description, sort);
            System.out.println(tagsWithDescriptionOrName);
            result.retainAll(tagsWithDescriptionOrName);
            System.out.println(result);

        }
        return result;
    }

    @Override
    public List<GiftCertificate> getByDescriptionOrName(String description, String sort) {
        return dao.getByDescriptionOrName(description, sort);
    }
}
