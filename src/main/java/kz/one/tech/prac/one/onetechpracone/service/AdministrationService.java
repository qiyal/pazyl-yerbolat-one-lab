package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.repository.impl.GroupRepositoryImpl;
import kz.one.tech.prac.one.onetechpracone.repository.impl.ProfessorRepositoryImpl;
import kz.one.tech.prac.one.onetechpracone.repository.impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdministrationService {
    private StudentRepositoryImpl studentRepository;
    private GroupRepositoryImpl groupRepository;
    private ProfessorRepositoryImpl professorRepository;

    @Autowired
    public AdministrationService(StudentRepositoryImpl studentRepository, GroupRepositoryImpl groupRepository, ProfessorRepositoryImpl professorRepository) {
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

    public Professor createNewProfessor(String firstName, String lastName, String email, String departmentName) {
        return Professor.professorBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .departmentName(departmentName)
                .build();
    }

    public Group createNewGroup(String name, Integer numberCount, Professor professor) {
        return Group.groupBuilder()
                .name(name)
                .memberCount(numberCount)
                .supervisor(professor)
                .build();
    }

    public void addUserToList(Student student) {
        studentRepository.addStudent(student);
    }

    public void addProfessorToList(Professor professor) {
        professorRepository.addProfessor(professor);
    }

    public void addGroupToList(Group group) {
        groupRepository.addGroup(group);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessor();
    }

    public List<Group> getAllGroups() {
        return groupRepository.getAllGroup();
    }
}
