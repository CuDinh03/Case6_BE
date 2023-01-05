package com.example.casestudy6.controller;

import com.example.casestudy6.model.Status;
import com.example.casestudy6.service.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/statuses")
public class StatusController {
    @Autowired
    StatusService statusService;
    @GetMapping
    public ResponseEntity<Optional> findById(@RequestParam("currentId") Long currentId) {
        Optional<Status> status = statusService.findById(currentId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> saveStatus(@Valid @RequestBody Status status) {
        status.setPostDay(LocalDateTime.now());
        statusService.save(status);
        return new ResponseEntity(status, HttpStatus.CREATED);
    }
}
