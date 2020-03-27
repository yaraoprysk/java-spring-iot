package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.StudentService;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RequestMapping("/students")
@RestController
public class StudentsController {

    private Map<Integer, Student> students = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable("id") Integer studentId) {
        return students.get(studentId);
    }

    @GetMapping
    public List<Student> getStudents(){
        return new LinkedList<Student>(students.values());
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student createStudent(@RequestBody Student student) {
        student.setId(idCounter.incrementAndGet());
        students.put(student.getId(), student);
        return student;
    }

    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student){
        student.setId(studentId);
        return students.put(studentId, student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Integer studentId){
        HttpStatus status = students.remove(studentId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    public StudentService getStudentService() {
        return this.studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}