package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring.rest.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
