package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.repository.GroupRepository;
import kz.one.tech.prac.one.onetechpracone.repository.StudentRepository;
import kz.one.tech.prac.one.onetechpracone.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdministrationService {
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private ProfessorRepository professorRepository;

    @Autowired
    public AdministrationService(StudentRepository studentRepository, GroupRepository groupRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.professorRepository = professorRepository;
    }

    public Student createNewUser(String firstName, String lastName, LocalDate lastSubmissionDate, Double gpa, String city, Boolean isHaveScholarship) {
        return Student.studentBuilder()
                      .firstName(firstName)
                      .lastName(lastName)
                      .lastSubmissionDate(lastSubmissionDate)
                      .gpa(gpa)
                      .city(city)
                      .isHaveScholarship(isHaveScholarship)
                      .build();
    }

    public void addUserToList(Student student) {
        studentRepository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

}