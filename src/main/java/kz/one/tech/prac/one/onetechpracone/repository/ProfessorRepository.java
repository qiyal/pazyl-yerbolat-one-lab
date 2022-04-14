package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Professor;

import java.util.List;

public interface ProfessorRepository {
    void insert(String firstName, String lastName, String email, String departmentName);
    void delete(Integer id);
    List<Professor> selectAll();
    List<Professor> findByDepartmentName(String departmentName);
}
