package ua.lviv.iot.spring.rest.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractService<University> {

    protected abstract JpaRepository<University,Integer> getRepository();

    public University create(University university) {
        return getRepository().save(university);
    }

    public University findById(Integer id) {
        if (getRepository().findById(id).isPresent()){
            return getRepository().findById(id).get();
        } else {
            return null;
        }
    }

    public List<University> getAll() {
        return getRepository().findAll();
    }

    public University delete(Integer id) {
        if (getRepository().findById(id).isPresent()){
            University possibleObject = getRepository().findById(id).get();
            getRepository().deleteById(id);
            return possibleObject;
        } else {
            return null;
        }
    }

    public List<University> findAll() {
        return getRepository().findAll();
    }

}
