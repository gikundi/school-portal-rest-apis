package co.ke.codemity.school.portalapis.services;

import co.ke.codemity.school.portalapis.entities.kyeni.KyeniStudents;
import co.ke.codemity.school.portalapis.entities.mbiruri.MbiruriStudents;
import co.ke.codemity.school.portalapis.repository.kyeni.KyeniStudentRepository;
import co.ke.codemity.school.portalapis.repository.mbiruri.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denis Gikundi on 17/10/2020.
 */

@Service
public class StudentService {

    @Autowired
    KyeniStudentRepository kyeniStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<MbiruriStudents> studentsList() {
        List<MbiruriStudents> students = null;
        try {
            students = studentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return students;
    }

    public List<KyeniStudents> studentsKyeniList() {
        List<KyeniStudents> kyenistudents = null;
        try {
            kyenistudents = kyeniStudentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return kyenistudents;
    }
}
