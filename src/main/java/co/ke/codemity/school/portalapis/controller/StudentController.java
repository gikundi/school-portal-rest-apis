package co.ke.codemity.school.portalapis.controller;


import co.ke.codemity.school.portalapis.entities.kyeni.KyeniStudents;
import co.ke.codemity.school.portalapis.entities.mbiruri.MbiruriStudents;
import co.ke.codemity.school.portalapis.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Denis Gikundi on 17/10/2020.
 */

@RestController
@RequestMapping(value = "api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/mbiruri/students")
    public List<MbiruriStudents> studentsList() {
       return studentService.studentsList();
    }

    @GetMapping("/kyeni/students")
    public List<KyeniStudents> studentsKyeniList() {
        return studentService.studentsKyeniList();
    }



}
