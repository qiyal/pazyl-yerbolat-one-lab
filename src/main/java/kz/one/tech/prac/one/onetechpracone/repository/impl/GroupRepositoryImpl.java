package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.mapper.GroupMapper;
import kz.one.tech.prac.one.onetechpracone.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {
    private JdbcTemplate jdbcTemplate;

    private final static String TABLE_NAME = "group_";
    private final static String INSERT_NEW_GROUP = "INSERT INTO " + TABLE_NAME + " (name, member_count, supervisor_id) VALUES(?, ?, ?)";
    private final static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private final static String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
    private final static String FIND_BY_NAME_LIKE = "SELECT * FROM " + TABLE_NAME + " WHERE name LIKE ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(String name, Integer memberCount, Integer supervisorId) {
        this.jdbcTemplate.update(INSERT_NEW_GROUP, name, memberCount, supervisorId);
    }

    @Override
    public void delete(Integer id) {
        this.jdbcTemplate.update(DELETE_BY_ID, id);
    }

    @Override
    public List<Group> selectAll() {
        return this.jdbcTemplate.query(SELECT_ALL, new GroupMapper());
    }

    @Override
    public List<Group> findByNameLike(String name) {
        return this.jdbcTemplate.query(FIND_BY_NAME_LIKE, new GroupMapper(), name);
    }
}
