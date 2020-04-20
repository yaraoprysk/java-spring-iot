package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.SubjectService;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@RequestMapping("/subjects")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable("id") Integer subjectId) {
        Subject subject = subjectService.findById(subjectId);
        if (subject != null) {
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject newSubject = subjectService.create(subject);
        if (newSubject != null) {
            return new ResponseEntity<>(newSubject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") Integer subjectId, @RequestBody Subject subject) {
        Subject oldSubject = subjectService.updateSubject(subject, subjectId);
        if (oldSubject != null) {
            return new ResponseEntity<>(oldSubject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") Integer subjectId) {
        if (subjectService.delete(subjectId) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
