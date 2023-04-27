package com.epam.esm.repository.daoImplementation;

import com.epam.esm.repository.daoInterfaces.TagDao;
import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.entities.Tag;
import com.epam.esm.repository.mappers.GiftCertificateMapper;
import com.epam.esm.repository.mappers.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class TagDaoImpl implements TagDao {


    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_ALL = "select * from tag";
    private final String SQL_FIND_ENTITY = "select * from tag where id = ?";
    private final String SQL_DELETE_ENTITY = "delete from tag where id = ?";
    private final String SQL_INSERT_ENTITY = "insert into tag(name) values(?)";

    public TagDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Tag entity) {
        return jdbcTemplate.update(SQL_INSERT_ENTITY, entity.getId(), entity.getName()) > 0;
    }

    @Override
    public Tag getById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_ENTITY, new TagMapper(), id);
    }

    @Override
    public List<Tag> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new TagMapper());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update(SQL_DELETE_ENTITY, id) > 0;
    }
}
