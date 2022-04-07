package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> studentList;

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentList;
    }

    @Override
    public List<Student> findStudentsByFirstNameAndLastName(String name) {
        return studentList.stream()
                .filter(
                        item -> item.getFirstName().equalsIgnoreCase(name) || item.getLastName().equalsIgnoreCase(name)
                )
                .collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void insertStudent(Student student) {
        studentList.add(student);
    }
}
