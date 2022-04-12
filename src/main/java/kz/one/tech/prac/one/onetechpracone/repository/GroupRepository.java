package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Group;

import java.util.List;

public interface GroupRepository {
    List<Group> getAllGroup();
    Group getGroupByName();
    void addGroup(Group group);
}
