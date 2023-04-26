package com.epam.esm.repository.mappers;


import com.epam.esm.repository.entities.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagMapper implements RowMapper<Tag> {
    @Override
    public Tag mapRow(ResultSet rs, int i) throws SQLException {
        Tag entity = new Tag();
        entity.setId(rs.getInt("id"));
        entity.setName(rs.getString("name"));
        return entity;
    }
}
