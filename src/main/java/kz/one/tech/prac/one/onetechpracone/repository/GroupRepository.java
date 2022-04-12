package kz.one.tech.prac.one.onetechpracone.repository;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface GroupRepository {
    List<Group> getAllGroup();
    Group getGroupByName();
    void addGroup(Group group);
}
