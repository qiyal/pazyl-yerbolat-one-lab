package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudent();
    List<Student> findStudentsByFirstNameAndLastName(String name);
    void addStudent(Student student);
    void insertStudent(Student student);
}
