package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Student;

import java.util.List;

public interface StudentRepository {
    void insert(Integer groupId, String firstName, String lastName, String city);
    void delete(Integer id);
    List<Student> selectAll();
    List<Student> findByFirstNameLikeOrLastNameLike(String name);
}
