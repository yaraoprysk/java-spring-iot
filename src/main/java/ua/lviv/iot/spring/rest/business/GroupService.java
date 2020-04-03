package ua.lviv.iot.spring.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.GroupRepository;
import ua.lviv.iot.spring.rest.model.Group;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }
}
