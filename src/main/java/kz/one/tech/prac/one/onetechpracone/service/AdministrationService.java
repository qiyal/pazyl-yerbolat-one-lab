package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.repository.impl.GroupRepositoryImpl;
import kz.one.tech.prac.one.onetechpracone.repository.impl.ProfessorRepositoryImpl;
import kz.one.tech.prac.one.onetechpracone.repository.impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createNewStudent(Integer groupId, String firstName, String lastName, String city) {
        studentRepository.insert(groupId, firstName, lastName, city);
    }

    public void createNewProfessor(String firstName, String lastName, String email, String departmentName) {
        this.professorRepository.insert(firstName, lastName, email, departmentName);
    }

    public void createNewGroup(String name, Integer memberCount, Integer supervisorId) {
        this.groupRepository.insert(name, memberCount, supervisorId);
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.selectAll();
    }

    public List<Professor> getAllProfessors() {
        return this.professorRepository.selectAll();
    }

    public List<Group> getAllGroups() {
        return this.groupRepository.selectAll();
    }
}
