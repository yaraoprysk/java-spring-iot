package ua.lviv.iot.spring.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.GroupRepository;
import ua.lviv.iot.spring.rest.model.Group;

@Service
public class GroupService extends AbstractService<Group> {

    @Autowired
    private GroupRepository groupRepository;

    public Group updateGroup(Group group, Integer id) {
        if (groupRepository.existsById(id)) {
            Group oldGroup = new Group(groupRepository.findById(id).get());
            group.setId(id);
            groupRepository.save(group);
            return oldGroup;
        } else {
            return null;
        }
    }

    @Override
    protected JpaRepository<Group, Integer> getRepository() {
        return groupRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
