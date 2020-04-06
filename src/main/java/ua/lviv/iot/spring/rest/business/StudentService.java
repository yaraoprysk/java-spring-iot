package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.StudentRepository;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> getStudent(Integer studentId) {
        if(studentRepository.existsById(studentId)) {
            Student selectedSweater = studentRepository.findById(studentId).get();
            return new ResponseEntity<Student>(selectedSweater,HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Student> updateStudent(Student studentToUpdate, Integer id) {
        if (studentRepository.existsById(id)) {
            studentToUpdate.setId(id);
            Student updatedSweater = studentRepository.save(studentToUpdate);
            return new ResponseEntity<Student>(updatedSweater, HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public HttpStatus deleteStudent(Integer studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> getAllByFirstName(String firstName){
        return studentRepository.findAllByFirstName(firstName);
    }
}
