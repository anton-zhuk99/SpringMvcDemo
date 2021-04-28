package com.example.mvcdemo.repository.impl;

import com.example.mvcdemo.model.Consumer;
import com.example.mvcdemo.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository // @Component
public class ConsumerRepositoryImpl implements ConsumerRepository {

    @Autowired
    private Connection connection;

    @Override
    public Consumer get(Integer id) {
        Consumer consumer = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM consumers WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                consumer = new Consumer();
                consumer.setId(rs.getInt("id"));
                consumer.setName(rs.getString("name"));
                consumer.setDistrict(rs.getString("district"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumer;
    }
}
