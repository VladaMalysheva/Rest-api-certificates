package com.epam.esm.repository.daoImplementation;

import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.mappers.GiftCertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class GiftCertificateDaoImpl implements GiftCertificateDao {

    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_ALL = "select * from gift_certificate";
    private final String SQL_FIND_ENTITY = "select * from gift_certificate where id = ?";
    private final String SQL_DELETE_ENTITY = "delete from gift_certificate where id = ?";
    private final String SQL_INSERT_ENTITY = "insert into gift_certificate(name, description, price, duration, create_date, last_update_date) values(?,?,?,?,?,?)";
    private final String SQL_UPDATE_ENTITY = "insert into gift_certificate set name=?, description=?, price=?, duration=?, create_date=?, last_update_date=? where id = ?";

    @Autowired
    public GiftCertificateDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public boolean save(GiftCertificate entity) {
        return jdbcTemplate.update(SQL_INSERT_ENTITY, entity.getId(), entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getDuration(), entity.getCreateDate(), entity.getLastUpdateDate()) > 0;
    }

    @Override
    public GiftCertificate getById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ENTITY, new GiftCertificateMapper(), id);
    }

    @Override
    public List<GiftCertificate> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new GiftCertificateMapper());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update(SQL_DELETE_ENTITY, id) > 0;
    }

    @Override
    public boolean update(GiftCertificate entity) {
        return jdbcTemplate.update(SQL_UPDATE_ENTITY, entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getDuration(), entity.getCreateDate(), entity.getLastUpdateDate(), entity.getId()) > 0;
    }
}
