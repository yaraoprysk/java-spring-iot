package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.StudentRepository;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@Service
public class StudentService extends AbstractService<Student>{

    @Autowired
    private StudentRepository studentRepository;

    public Student updateStudent(Student studentToUpdate, Integer id) {
        if (studentRepository.existsById(id)) {
            Student oldStudent = new Student(studentRepository.findById(id).get());
            studentToUpdate.setId(id);
            studentRepository.save(studentToUpdate);
            return oldStudent;
        } else {
            return null;
        }
    }

    @Override
    protected JpaRepository<Student, Integer> getRepository() {
        return studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> getAllByFirstName(String firstName){
        return studentRepository.findAllByFirstName(firstName);
    }
}
