package com.epam.esm.service;

import com.epam.esm.errorHandling.DbException;
import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.entities.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
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
    public boolean save(GiftCertificate entity) throws DbException {
        try {
            return dao.save(entity);
        } catch (SQLException e) {
            throw new DbException("Can't save gift certificate with id "+ entity.getId() +" to the database", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public GiftCertificate getById(int id) throws DbException {
        try {
            return dao.getById(id);
        } catch (SQLException e) {
            throw new DbException("Can't get gift certificate with id "+ id +" from the database", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<GiftCertificate> getAll(String sort) throws DbException {
        try {
            return dao.getAll(sort);
        } catch (SQLException e) {
            throw new DbException("Can't get all gift certificates from the database", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public boolean delete(int id) throws DbException {
        boolean result = false;
        try {
            result = dao.delete(id);
        } catch (SQLException ex) {
            throw new DbException("Can't delete gift certificate with id "+ id +" from the database", HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @Override
    public boolean update(GiftCertificate entity) throws DbException{
        boolean result = false;
        try {
            result = dao.update(entity);
        } catch (SQLException ex) {
            throw new DbException("Can't update gift certificate with id "+ entity.getId() +" from the database", HttpStatus.NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<GiftCertificate> getByTagName(String name, String sort, String description) throws DbException{
        List<GiftCertificate> result = null;
        try {
            result = dao.getByTagName(name, sort);
        } catch (SQLException e) {
            throw new DbException("Can't get gift certificate with tag "+ name +" from the database", HttpStatus.NOT_FOUND);
        }
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
    public List<GiftCertificate> getByDescriptionOrName(String description, String sort) throws DbException {
        List<GiftCertificate> result = null;
        try {
            result = dao.getByDescriptionOrName(description, sort);
        } catch (SQLException ex) {
            throw new DbException("Can't get gift certificate with description or name "+ description +" from the database", HttpStatus.NOT_FOUND);
        }
        return result;
    }
}
