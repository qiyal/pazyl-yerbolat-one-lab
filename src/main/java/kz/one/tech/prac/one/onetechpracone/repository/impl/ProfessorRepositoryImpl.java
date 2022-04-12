package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.repository.ProfessorRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {
    private List<Professor> professorList;

    @PostConstruct
    public void init() {
        professorList = new ArrayList<>();
    }

    @Override
    public List<Professor> getAllProfessor() {
        return professorList;
    }

    @Override
    public List<Professor> getProfessorsByFirstNameOrLastName() {
        return null;
    }

    @Override
    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }
}
