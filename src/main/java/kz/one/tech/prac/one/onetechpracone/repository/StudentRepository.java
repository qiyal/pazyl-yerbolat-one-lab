package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface StudentRepository {
    List<Student> getAllStudent();
    List<Student> findStudentsByFirstNameAndLastName(String name);
    void addStudent(Student student);
    void insertStudent(Student student);
}
