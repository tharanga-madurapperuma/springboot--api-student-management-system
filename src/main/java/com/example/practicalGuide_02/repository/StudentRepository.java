package com.example.practicalGuide_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.practicalGuide_02.Model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByYearsOfEnrollment(int yearsOfEnrollment);

    @Query("SELECT department FROM Student WHERE id = ?1")
    String findDepartmentById(long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student WHERE yearsOfEnrollment = ?1")
    void deleteStudentByYearsOfEnrollment(int yearsOfEnrollment);
}