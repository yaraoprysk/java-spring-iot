package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.GroupService;
import ua.lviv.iot.spring.rest.model.Group;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group newGroup = groupService.create(group);
        if (newGroup != null) {
            return new ResponseEntity<>(newGroup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable("id") Integer groupId) {
        Group group = groupService.findById(groupId);
        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable("id") Integer groupId, @RequestBody Group group) {
        Group oldGroup = groupService.updateGroup(group, groupId);
        if (oldGroup != null) {
            return new ResponseEntity<>(oldGroup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable("id") Integer groupId) {
        if (groupService.delete(groupId) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
