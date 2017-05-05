package com.xsc.repository;

import com.xsc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XSC on 2017/5/5.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
