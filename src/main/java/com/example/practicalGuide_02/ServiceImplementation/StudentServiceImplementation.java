package com.example.practicalGuide_02.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practicalGuide_02.Model.Student;
import com.example.practicalGuide_02.Service.StudentService;
import com.example.practicalGuide_02.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
            ()-> new RuntimeException()
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearsOfEnrollment(student.getYearsOfEnrollment());

        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow( () -> new RuntimeException());
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByYearsOfExperience(int years){
        return studentRepository.findByYearsOfEnrollment(years);
    }

    @Override
    public String findDepartmentById(long id){
        return studentRepository.findDepartmentById(id);
    }

    @Override
    public String deleteStudentByYearsOfEnrollment(int years){
        studentRepository.deleteStudentByYearsOfEnrollment(years);
        return "Deleted Successfully";
    }
}
