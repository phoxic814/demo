package com.dao.jpa;

import com.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<Student, String> {
}
