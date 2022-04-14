package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.model.mapper.ProfessorMapper;
import kz.one.tech.prac.one.onetechpracone.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {
    private JdbcTemplate jdbcTemplate;
    private final static String TABLE_NAME = "professor_";
    private final static String INSERT_NEW_PROFESSOR = "INSERT INTO " + TABLE_NAME + " (first_name, last_name, email, department_name) VALUES (?, ?, ?, ?)";
    private final static String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
    private final static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private final static String FIND_BY_DEPARTMENT_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE department_name = ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(String firstName, String lastName, String email, String departmentName) {
        this.jdbcTemplate.update(INSERT_NEW_PROFESSOR, firstName, lastName, email, departmentName);
    }

    @Override
    public void delete(Integer id) {
        this.jdbcTemplate.update(DELETE_BY_ID, id);
    }

    @Override
    public List<Professor> selectAll() {
        return this.jdbcTemplate.query(SELECT_ALL, new ProfessorMapper());
    }

    @Override
    public List<Professor> findByDepartmentName(String departmentName) {
        return this.jdbcTemplate.query(FIND_BY_DEPARTMENT_NAME, new ProfessorMapper(), departmentName);
    }
}
