package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SomeRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public SomeRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void dbCall(){
        jdbcTemplate.execute("select 1 from dual");
    }
}
