package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Professor;

import java.util.List;

public interface ProfessorRepository {
    List<Professor> getAllProfessor();
    List<Professor> getProfessorsByFirstNameOrLastName();
    void addProfessor(Professor professor);
}
