package kz.one.tech.prac.one.onetechpracone.model.mapper;

import kz.one.tech.prac.one.onetechpracone.model.Professor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorMapper implements RowMapper<Professor> {

    @Override
    public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Professor professor = new Professor();
        professor.setId(rs.getInt("id"));
        professor.setFirstName(rs.getString("first_name"));
        professor.setLastName(rs.getString("last_name"));
        professor.setEmail(rs.getString("email"));
        professor.setDepartmentName(rs.getString("department_name"));

        return professor;
    }
}
