package kz.one.tech.prac.one.onetechpracone.model.mapper;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        LocalDate localDate = rs.getDate("last_submission_date") == null ? null : LocalDate.parse(rs.getDate("last_submission_date").toString());

        student.setId(rs.getInt("id"));
        student.setId(rs.getInt("group_id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setLastSubmissionDate(localDate);
        student.setGpa(rs.getDouble("gpa"));
        student.setCity(rs.getString("city"));
        student.setIsHaveScholarship(rs.getBoolean("is_have_scholarship"));

        return student;
    }
}
