package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Group;

import java.util.List;

public interface GroupRepository {
    void insert(String name, Integer memberCount, Integer supervisorId);
    void delete(Integer id);
    List<Group> selectAll();
    List<Group> findByNameLike(String name);
}
