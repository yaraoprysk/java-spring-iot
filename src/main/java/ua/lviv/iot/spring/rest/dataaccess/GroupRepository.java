package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring.rest.model.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
