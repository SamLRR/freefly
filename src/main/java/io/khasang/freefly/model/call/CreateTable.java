package io.khasang.freefly.model.call;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable() {

    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String create() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "id INTEGER NOT NULL, \n" +
                    "name CHARACTER VARYING(255), \n" +
                    "description CHARACTER VARYING(255), \n" +
                    "color_id INTEGER, \n" +
                    "CONSTRAINT cats_pkey PRIMARY KEY(id)\n" +
                    ")");
            return "table created";
        } catch (Exception e) {
            return "something going wrong ... \n" + e;
        }
    }

    public String insert() {
        try {
            jdbcTemplate.execute("INSERT INTO cats VALUES (1,'barsik','good',2)");
            return "data insert";
        } catch (Exception e) {
            return "error insert data ... " + e;
        }
    }

    public String update() {
        try {
            jdbcTemplate.execute("UPDATE cats SET color_id=5 where color_id=2");
            return "data insert";
        } catch (Exception e) {
            return "error insert data ... " + e;
        }
    }
}
