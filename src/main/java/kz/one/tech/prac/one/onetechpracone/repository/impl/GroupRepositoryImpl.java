package kz.one.tech.prac.one.onetechpracone.repository.impl;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.repository.GroupRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {
    private List<Group> groupList;

    @PostConstruct
    public void init() {
        groupList = new ArrayList<>();
    }

    @Override
    public List<Group> getAllGroup() {
        return groupList;
    }

    @Override
    public Group getGroupByName() {
        return null;
    }

    @Override
    public void addGroup(Group group) {
        groupList.add(group);
    }
}
