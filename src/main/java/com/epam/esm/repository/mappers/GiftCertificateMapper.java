package com.epam.esm.repository.mappers;

import com.epam.esm.repository.entities.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftCertificateMapper implements RowMapper<GiftCertificate> {

    public GiftCertificate mapRow(ResultSet resultSet, int i) throws SQLException {

        GiftCertificate entity = new GiftCertificate();
        entity.setId(resultSet.getInt("id"));
        entity.setName(resultSet.getString("name"));
        entity.setDescription(resultSet.getString("description"));
        entity.setPrice(resultSet.getInt("price"));
        entity.setDuration(resultSet.getInt("duration"));
        entity.setCreateDate(resultSet.getDate("create_date"));
        entity.setLastUpdateDate(resultSet.getDate("last_update_date"));
        return entity;
    }
}
