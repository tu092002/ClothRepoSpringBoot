package com.sergio.jwt.backend.database;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initializeDatabase() {
        jdbcTemplate.execute("ALTER TABLE Image MODIFY COLUMN data MEDIUMBLOB");
    }
}
