package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.SubjectRepository;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@Service
public class SubjectService extends AbstractService<Subject> {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject updateSubject(Subject subject, Integer id) {
        if (subjectRepository.existsById(id)) {
            Subject oldSubject = new Subject(subjectRepository.findById(id).get());
            subject.setId(id);
            subjectRepository.save(subject);
            return oldSubject;
        } else {
            return null;
        }
    }

    @Override
    protected JpaRepository<Subject, Integer> getRepository() {
        return subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
}
