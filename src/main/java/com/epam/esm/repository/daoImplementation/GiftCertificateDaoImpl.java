package com.epam.esm.repository.daoImplementation;

import com.epam.esm.repository.daoInterfaces.GiftCertificateDao;
import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.mappers.GiftCertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
@Component
public class GiftCertificateDaoImpl implements GiftCertificateDao {


    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_BY_DESCRIPTION_OR_NAME = "select * from gift_certificate where name LIKE ? or description like ?";

//    private final String SQL_GET_ALL_SORTED = "select * from gift_certificate order by name ?";
    private final String SQL_GET_ALL = "select * from gift_certificate";
    private final String SQL_FIND_ENTITY = "select * from gift_certificate where id = ?";
    private final String SQL_DELETE_ENTITY = "delete from gift_certificate where id = ?";
    private final String SQL_INSERT_ENTITY = "insert into gift_certificate(name, description, price, duration, create_date, last_update_date) values(?,?,?,?,?,?)";
    private final String SQL_UPDATE_ENTITY = "update gift_certificate set name=?, description=?, price=?, duration=?, create_date=?, last_update_date=? where id = ?";

    private final String SQL_GET_BY_TAG_NAME = "select * from gift_certificate as g join certificate_tag as c on g.id=c.certificate_id join tag as t on c.tag_id = t.id where t.name like ?";

    @Autowired
    public GiftCertificateDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public boolean save(GiftCertificate entity) {
        return jdbcTemplate.update(SQL_INSERT_ENTITY, entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getDuration(), entity.getCreateDate(), entity.getLastUpdateDate()) > 0;
    }

    @Override
    public GiftCertificate getById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ENTITY, new GiftCertificateMapper(), id);
    }


    @Override
    public List<GiftCertificate> getAll(String sort) {
        String s = sort != null ? " order by name " + sort : "";
        System.out.println(SQL_GET_ALL+s);
        return jdbcTemplate.query(SQL_GET_ALL+s, new GiftCertificateMapper());
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

    @Override
    public List<GiftCertificate> getByTagName(String name, String sort) {
        String s = sort != null ? " order by g.name " + sort : "";
        System.out.println(SQL_GET_BY_TAG_NAME + s);
        return jdbcTemplate.query(SQL_GET_BY_TAG_NAME + s, new GiftCertificateMapper(), name);
    }

    @Override
    public List<GiftCertificate> getByDescriptionOrName(String description, String sort) {
        String s = sort != null ? " order by name " + sort : "";
        System.out.println(SQL_GET_BY_DESCRIPTION_OR_NAME + s);
        return jdbcTemplate.query(SQL_GET_BY_DESCRIPTION_OR_NAME + s, new GiftCertificateMapper(), "%"+description+"%", "%"+description+"%");
    }
}
