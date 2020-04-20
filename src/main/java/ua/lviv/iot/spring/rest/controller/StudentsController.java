package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.StudentService;
import ua.lviv.iot.spring.rest.model.Student;
import java.util.List;


@RequestMapping("/students")
@RestController
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Integer studentId) {
        Student student = studentService.findById(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Student> getStudents(final @RequestParam(name = "firstName", required = false) String firstName){
        if (firstName == null) {
            return studentService.findAll();
        }
        return studentService.getAllByFirstName(firstName);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.create(student);
        if (newStudent != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        Student oldStudent = studentService.updateStudent(student, studentId);
        if (oldStudent != null) {
            return new ResponseEntity<>(oldStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer studentId){
        if (studentService.delete(studentId) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public StudentService getStudentService() {
        return this.studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
