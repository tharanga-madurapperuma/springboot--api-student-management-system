package com.example.practicalGuide_02.Controller;

import com.example.practicalGuide_02.Model.Student;
import com.example.practicalGuide_02.Service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

 
    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

    @GetMapping("getStudentByYearsOfEnrollment/{yearsOfEnrollment}")
    public List<Student> getStudentByYearsOfExperience(@PathVariable("yearsOfEnrollment") int yearsOfEnrollment){
        return studentService.getStudentByYearsOfExperience(yearsOfEnrollment);
    }

    @GetMapping("getDepartmentById/{id}")
    public String findDepartmentById(@PathVariable("id") long id){
        return studentService.findDepartmentById(id);
    }

    @DeleteMapping("deleteStudentByYearsOfEnrollment/{yearsOfEnrollment}")
    public String deleteStudentByYearsOfEnrollment(@PathVariable("yearsOfEnrollment") int yearsOfEnrollment){
        return studentService.deleteStudentByYearsOfEnrollment(yearsOfEnrollment);
    }
}
