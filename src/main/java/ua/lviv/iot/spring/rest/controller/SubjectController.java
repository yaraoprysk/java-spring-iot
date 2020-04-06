package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        return this.subjectService.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Subject createSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
        return subject;
    }
}
