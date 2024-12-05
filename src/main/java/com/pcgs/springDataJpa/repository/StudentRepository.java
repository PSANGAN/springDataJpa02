package com.pcgs.springDataJpa.repository;

import com.pcgs.springDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}