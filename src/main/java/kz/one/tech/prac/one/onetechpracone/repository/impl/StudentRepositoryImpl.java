package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.model.mapper.StudentMapper;
import kz.one.tech.prac.one.onetechpracone.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private JdbcTemplate jdbcTemplate;

    private final static String TABLE_NAME = "student_";
    private final static String INSERT_NEW_STUDENT = "INSERT INTO " + TABLE_NAME + " (group_id, first_name, last_name, city) VALUES(?, ?, ?, ?)";
    private final static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private final static String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
    private final static String FIND_BY_FIRSTNAME_LIKE_OR_LASTNAME_LIKE = "SELECT * FROM " + TABLE_NAME + " WHERE first_name LIKE ?1 OR last_name LIKE ?1";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Integer groupId, String firstName, String lastName, String city) {
        this.jdbcTemplate.update(INSERT_NEW_STUDENT, groupId, firstName, lastName, city);
    }

    @Override
    public void delete(Integer id) {
        this.jdbcTemplate.update(DELETE_BY_ID, id);
    }

    @Override
    public List<Student> selectAll() {
        return this.jdbcTemplate.query(SELECT_ALL, new StudentMapper());
    }

    @Override
    public List<Student> findByFirstNameLikeOrLastNameLike(String name) {
        return this.jdbcTemplate.query(FIND_BY_FIRSTNAME_LIKE_OR_LASTNAME_LIKE, new StudentMapper(), name);
    }
}
